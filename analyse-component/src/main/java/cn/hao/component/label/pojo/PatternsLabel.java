package cn.hao.component.label.pojo;

import cn.hao.component.label.AbstractLabel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@XmlType(name = "patterns")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatternsLabel extends AbstractLabel {
    @XmlElement(name = "head")
    private String head;
    @XmlElement(name = "content")
    private String content;
    @XmlElement(name = "tail")
    private String tail;
    @XmlElement(name = "expel")
    private String expel;


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getExpel() {
        return expel;
    }

    public void setExpel(String expel) {
        this.expel = expel;
    }

    @Override
    public String toString() {
        return "PatternsLabel{" +
                "head='" + head + '\'' +
                ", content='" + content + '\'' +
                ", tail='" + tail + '\'' +
                ", expel='" + expel + '\'' +
                '}';
    }
}
