package cn.hao.component.label.handle;

import cn.hao.api.IHandler;
import cn.hao.api.ITransferCache;
import cn.hao.component.label.pojo.FuncLabel;
import cn.hao.component.label.pojo.FuncsLabel;
import cn.hao.component.label.pojo.RootLabel;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Tianbohao on 2018/11/14.
 */
@Component("rootHandler")
public class RootHandler implements IHandler {
    @Override
    public void hand(ITransferCache cache) {
        RootLabel rootLabel = (RootLabel) cache.getLabel();
        FuncsLabel funcsLabel = rootLabel.getFuncsLabel();
        if(null != funcsLabel){
            List<FuncLabel> funcLabels = funcsLabel.getFuncLabelList();
        }
        //TODO 函数处理
        Collection<List> tableLists = cache.getTableMap().values();
        for(List table : tableLists){
            if(null == table){
                continue;
            }
            cache.getResultList().addAll(table);
        }
        //TODO 数据聚合
        build(cache);
    }

    private void build(ITransferCache cache){
        Collection<Map> commonMaps = cache.getCommonMap().values();
        Iterator<Map> iterator = commonMaps.iterator();
        for (Map map : cache.getResultList()){
            while (iterator.hasNext()){
                map.putAll(iterator.next());
            }
        }
    }
}
