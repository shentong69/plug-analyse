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
@XmlType(name = "functions")
@XmlAccessorType(XmlAccessType.FIELD)
public class FuncsLabel extends AbstractLabel {
    @XmlElement(name = "function")
    private List<FuncLabel> funcLabelList;

    public List<FuncLabel> getFuncLabelList() {
        return funcLabelList;
    }

    public void setFuncLabelList(List<FuncLabel> funcLabelList) {
        this.funcLabelList = funcLabelList;
    }

    @Override
    public String toString() {
        return "FuncsLabel{" +
                "funcLabelList=" + funcLabelList +
                '}';
    }
}
