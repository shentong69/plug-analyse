package cn.hao.api;

import cn.hao.model.ResultInfo;

import java.io.IOException;

/**
 * 解析者
 * Created by Tianbohao on 2018/10/23.
 */
public interface IDataParser {

    void hand(ITransferCache cache);

    ResultInfo parse(String filePath, String xmlPath) throws IOException;
}
