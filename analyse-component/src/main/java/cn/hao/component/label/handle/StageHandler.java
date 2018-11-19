package cn.hao.component.label.handle;

import cn.hao.api.IHandler;
import cn.hao.api.ITransferCache;
import org.springframework.stereotype.Component;

/**
 * 解析队列1
 * Created by Tianbohao on 2018/11/7.
 */
@Component("stageHandler")
public class StageHandler implements IHandler{

    @Override
    public void hand(ITransferCache cache){
        return;
    }
}
