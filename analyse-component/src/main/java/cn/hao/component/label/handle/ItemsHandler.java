package cn.hao.component.label.handle;

import cn.hao.api.IHandler;
import cn.hao.api.ITransferCache;
import cn.hao.api.exception.IllegalAnalyseException;
import cn.hao.component.IComponent;
import cn.hao.component.label.pojo.ItemsLabel;
import cn.hao.component.label.pojo.PatternsLabel;
import cn.hao.component.label.pojo.StageLabel;
import cn.hao.component.label.pojo.ItemLabel;
import org.apache.oro.text.regex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析队列3
 * 分表（考虑到纵表配置习惯，所以分表逻辑层放到这块，key值预设index）
 * Created by Tianbohao on 2018/11/13.
 */
@Component("itemsHandler")
public class ItemsHandler implements IHandler {
    @Autowired
    private ItemHandler itemHandler;
    private Perl5Matcher matcher;
    private Perl5Compiler compiler;

    private List<Map<String,String>> tempDatas;

    ItemsHandler() {
        matcher = new Perl5Matcher();
        compiler = new Perl5Compiler();
        tempDatas = new ArrayList<>();
    }

    @Override
    public void hand(ITransferCache cache) {
        StageLabel stageLabel = (StageLabel) cache.getLabel();
        PatternsLabel patternsLabel = stageLabel.getPatternsLabel();

        String content = patternsLabel.getContent();
        if (null == content) {
            throw new IllegalAnalyseException("content label can not be null!");
        }
        try {
            Pattern contentPattern = compiler.compile(content);
            for(String stage : cache.getStageDatas()){
                PatternMatcherInput input = new PatternMatcherInput(stage);
                if (matcher.matches(input, contentPattern)) {
                    MatchResult result = matcher.getMatch();
                    Map<String, String> map = this.stage2Table(result, stageLabel.getItemsLabel());
                    if(stageLabel.getType().equals(IComponent.STAGE_COMMON)){
                        cache.getCommonMap().put(stageLabel.getId(),map);
                    }else {
                        tempDatas.add(map);
                    }
                }
            }

            if(!stageLabel.getType().equals(IComponent.STAGE_COMMON)){
                cache.getTableMap().put(stageLabel.getId(),tempDatas);
            }
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> stage2Table(MatchResult matchResult, ItemsLabel itemsLabel) {
        List<ItemLabel> itemLabelList = itemsLabel.getItemLabelList();
        Map<String, String> result = new HashMap();

        for (ItemLabel item : itemLabelList) {
            String key = item.getColumn();
            String value = matchResult.group(Integer.parseInt(item.getIndex()));
            itemHandler.init(item,value);
            result.put(key, itemHandler.getResultVal());
        }

        return result;
    }
}
