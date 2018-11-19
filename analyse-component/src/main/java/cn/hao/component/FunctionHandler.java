package cn.hao.component;

import cn.hao.component.label.pojo.StageLabel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Tianbohao on 2018/10/30.
 */
@Component
public class FunctionHandler {
    private Map<StageLabel, List> tempMap;

    public List<Map<String, String>> hand(){

        return null;
    }

    public Map<StageLabel, List> getTempMap() {
        return tempMap;
    }

    public void setTempMap(Map<StageLabel, List> tempMap) {
        this.tempMap = tempMap;
    }
}
