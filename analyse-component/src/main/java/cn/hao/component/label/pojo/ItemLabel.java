package cn.hao.component.label.pojo;

import cn.hao.component.label.AbstractLabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@XmlType(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemLabel extends AbstractLabel {
    @XmlAttribute(name = "column")
    private String column;
    @XmlAttribute(name = "operate")
    private String operate;
    @XmlAttribute(name = "detail")
    private String detail;
    @XmlAttribute(name = "index")
    private String index;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ItemLabel{" +
                "column='" + column + '\'' +
                ", operate='" + operate + '\'' +
                ", detail='" + detail + '\'' +
                ", index='" + index + '\'' +
                '}';
    }
}
