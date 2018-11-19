package cn.hao.model;

/**
 * Created by Tianbohao on 2018/10/23.
 */
public class RequestInfo {
    /*
    报文路径
     */
    private String filePath;
    /*
    解析配置路径
     */
    private String xmlPath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }
}
