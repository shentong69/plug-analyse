package cn.hao.component.label.pojo;

import cn.hao.component.label.AbstractLabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@XmlType(name = "stages")
@XmlAccessorType(XmlAccessType.FIELD)
public class StagesLabel extends AbstractLabel {
    @XmlElement(name = "stage")
    private List<StageLabel> stageLabelList;

    public List<StageLabel> getStageLabelList() {
        return stageLabelList;
    }

    public void setStageLabelList(List<StageLabel> stageLabelList) {
        this.stageLabelList = stageLabelList;
    }

    @Override
    public String toString() {
        return "StagesLabel{" +
                "stageLabelList=" + stageLabelList +
                '}';
    }
}
