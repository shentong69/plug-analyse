package cn.hao.component.label.pojo;

import cn.hao.api.ILabel;
import cn.hao.component.IComponent;
import cn.hao.component.label.AbstractLabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@XmlType(name = "stage")
@XmlAccessorType(XmlAccessType.FIELD)
public class StageLabel extends AbstractLabel implements ILabel{
    @XmlElement(name = "patterns")
    private PatternsLabel patternsLabel;
    @XmlElement(name = "items")
    private ItemsLabel itemsLabel;

    StageLabel(){
        super.setType(IComponent.STAGE_DEFAULT);
    }

    public PatternsLabel getPatternsLabel() {
        return patternsLabel;
    }

    public void setPatternsLabel(PatternsLabel patternsLabel) {
        this.patternsLabel = patternsLabel;
    }

    public ItemsLabel getItemsLabel() {
        return itemsLabel;
    }

    public void setItemsLabel(ItemsLabel itemsLabel) {
        this.itemsLabel = itemsLabel;
    }

    @Override
    public String toString() {
        return "StageLabel{" +
                "patternsLabel=" + patternsLabel +
                ", itemsLabel=" + itemsLabel +
                '}';
    }
}
