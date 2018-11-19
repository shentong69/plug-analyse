package cn.hao.model;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianbohao on 2018/11/6.
 */
public class ResultCache {
    private int dataType; // 0:数据流  1：段落集合  2：键值对列表
    private InputStream val0;
    private List<String> val1;
    private List<Map<String, String>> val2;

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public InputStream getVal0() {
        return val0;
    }

    public void setVal0(InputStream val0) {
        this.val0 = val0;
    }

    public List<String> getVal1() {
        return val1;
    }

    public void setVal1(List<String> val1) {
        this.val1 = val1;
    }

    public List<Map<String, String>> getVal2() {
        return val2;
    }

    public void setVal2(List<Map<String, String>> val2) {
        this.val2 = val2;
    }
}
