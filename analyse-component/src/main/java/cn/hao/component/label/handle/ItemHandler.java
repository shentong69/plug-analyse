package cn.hao.component.label.handle;

import cn.hao.api.IHandler;
import cn.hao.api.ITransferCache;
import cn.hao.component.label.pojo.ItemLabel;
import org.springframework.stereotype.Component;

/**
 * 成表（key值依据配置替换）
 * Created by Tianbohao on 2018/11/13.
 */
@Component("itemHandler")
public class ItemHandler implements IHandler{
    private ItemLabel itemLabel;
    private String resultVal;

    @Override
    public void hand(ITransferCache cache){

    }

    public void init(ItemLabel label,String val){
        this.itemLabel = label;
        this.resultVal = val;
    }

    public ItemLabel getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(ItemLabel itemLabel) {
        this.itemLabel = itemLabel;
    }

    public String getResultVal() {
        return resultVal;
    }

    public void setResultVal(String resultVal) {
        this.resultVal = resultVal;
    }
}
