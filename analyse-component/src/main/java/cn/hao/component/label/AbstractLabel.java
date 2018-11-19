package cn.hao.component.label;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractLabel {
    @XmlAttribute(name = "id")
    private String id;    //标签ID
    @XmlAttribute(name = "type")
    private String type;    //标签类型
    @XmlAttribute(name = "func")
    private String func;    //标签函数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }
}
