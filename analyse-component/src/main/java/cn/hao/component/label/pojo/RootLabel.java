package cn.hao.component.label.pojo;

import cn.hao.api.ILabel;
import cn.hao.component.label.AbstractLabel;

import javax.xml.bind.annotation.*;

/**
 * 根标签
 * Created by Tianbohao on 2018/10/30.
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootLabel extends AbstractLabel implements ILabel{
    @XmlElement(name = "stages")
    private StagesLabel stagesLabel;
    @XmlElement(name = "functions")
    private FuncsLabel funcsLabel;

    public StagesLabel getStagesLabel() {
        return stagesLabel;
    }

    public void setStagesLabel(StagesLabel stagesLabel) {
        this.stagesLabel = stagesLabel;
    }

    public FuncsLabel getFuncsLabel() {
        return funcsLabel;
    }

    public void setFuncsLabel(FuncsLabel funcsLabel) {
        this.funcsLabel = funcsLabel;
    }

    @Override
    public String toString() {
        return "RootLabel{" +
                "stagesLabel=" + stagesLabel +
                ", funcsLabel=" + funcsLabel +
                '}';
    }
}
