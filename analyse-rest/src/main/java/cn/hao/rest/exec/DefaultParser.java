package cn.hao.rest.exec;

import cn.hao.api.IDataParser;
import cn.hao.api.IHandler;
import cn.hao.api.ITransferCache;
import cn.hao.component.IComponent;
import cn.hao.component.JAXBUtil;
import cn.hao.component.label.handle.RootHandler;
import cn.hao.component.label.pojo.RootLabel;
import cn.hao.component.label.pojo.StageLabel;
import cn.hao.model.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.List;


/**
 * Created by Tianbohao on 2018/10/30.
 */
@Service
public class DefaultParser implements IDataParser, IHandler {
    private final Logger logger = LoggerFactory.getLogger(DefaultParser.class);
    private List<IHandler> handlers;
    private RootHandler rootHandler;

    @Override
    public void hand(ITransferCache cache) {
        for (IHandler handler : handlers) {
            handler.hand(cache);
        }
    }

    @Override
    public ResultInfo parse(String filePath, String xmlPath) throws IOException {
        int stage_key = 0;

        ResultInfo resultInfo = new ResultInfo();
        FileInputStream in = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);

        FileInputStream xmlStream = new FileInputStream(xmlPath);

        TransferCache cache = new TransferCache(this, br);
        try {
            RootLabel rootLabel = JAXBUtil.xml2pojo(xmlStream, RootLabel.class);
            List<StageLabel> stageLabelList = rootLabel.getStagesLabel().getStageLabelList();
            for (StageLabel stageLabel : stageLabelList) {
                if (null == stageLabel.getId()) {
                    stageLabel.setId(String.valueOf(stage_key));
                }
                cache.setLabel(stageLabel);
                cache.exec();
                stage_key++;
            }

            cache.setLabel(rootLabel);
            rootHandler.hand(cache);
            resultInfo.setResultData(cache.getResultList());
            resultInfo.setResultType(IComponent.RESULT_TYPE_SUCCESS);

            logger.debug("result info:{}",resultInfo);
        } catch (JAXBException e) {
            logger.error("parse error", e);
            resultInfo.setResultType(IComponent.RESULT_TYPE_ERROR);
        } finally {
            in.close();
            reader.close();
        }
        return resultInfo;
    }


    public void setHandlers(List<IHandler> handlers) {
        this.handlers = handlers;
    }

    public void setRootHandler(RootHandler rootHandler) {
        this.rootHandler = rootHandler;
    }
}
