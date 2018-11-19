package cn.hao.component.label.pojo;

import cn.hao.component.label.AbstractLabel;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@XmlType(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemsLabel extends AbstractLabel {
    @XmlAttribute(name = "split")
    private String split;
    @XmlElement(name = "item")
    private List<ItemLabel> itemLabelList;

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public List<ItemLabel> getItemLabelList() {
        return itemLabelList;
    }

    public void setItemLabelList(List<ItemLabel> itemLabelList) {
        this.itemLabelList = itemLabelList;
    }

    @Override
    public String toString() {
        return "ItemsLabel{" +
                "split='" + split + '\'' +
                ", itemLabelList=" + itemLabelList +
                '}';
    }
}
