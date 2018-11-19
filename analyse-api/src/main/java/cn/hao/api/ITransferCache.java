package cn.hao.api;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianbohao on 2018/11/14.
 */
public interface ITransferCache {

    void exec();

    ILabel getLabel();

    void setLabel(ILabel label);

    /**
     * 初始流数据
     * @return
     */
    BufferedReader getBufferedReader();

    /**
     * 段落数据
     * @return
     */
    List<String> getStageDatas();

    /**
     * 表数据
     * @return
     */
    Map<String,List> getTableMap();

    /**
     * 表数据(公共)
     * @return
     */
    Map<String,Map> getCommonMap();

    /**
     * 结果集
     * @return
     */
    List<Map<String,String>> getResultList();
}
