package cn.hao.rest.exec;

import cn.hao.api.IDataParser;
import cn.hao.api.ILabel;
import cn.hao.api.ITransferCache;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianbohao on 2018/11/14.
 */
public class TransferCache implements ITransferCache{
    private IDataParser parser;
    private ILabel label;
    private BufferedReader bufferedReader;
    private List<String> stageDatas;
    private Map<String,Map> commonMap;
    private Map<String,List> tableMap;
    private List<Map<String,String>> resultList;

    TransferCache(IDataParser parser, BufferedReader bufferedReader) {
        this.parser = parser;
        this.bufferedReader = bufferedReader;
        this.stageDatas = new ArrayList<>();
        this.commonMap = new HashMap<>();
        this.tableMap = new HashMap<>();
        this.resultList = new ArrayList<>();
    }

//    TransferCache(IDataParser parser, ILabel label, InputStream inputStream) {
//        this.parser = parser;
//        this.label = label;
//        this.inputStream = inputStream;
//        this.stageDatas = new ArrayList<>();
//        this.commonMap = new HashMap<>();
//        this.tableMap = new HashMap<>();
//    }

    @Override
    public void exec(){
        parser.hand(this);
    }

    @Override
    public ILabel getLabel() {
        return label;
    }

    @Override
    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    @Override
    public List<String> getStageDatas() {
        return stageDatas;
    }

    @Override
    public Map<String, List> getTableMap() {
        return tableMap;
    }

    @Override
    public Map<String, Map> getCommonMap() {
        return commonMap;
    }

    @Override
    public List<Map<String, String>> getResultList() {
        return resultList;
    }

    @Override
    public void setLabel(ILabel label) {
        this.label = label;
    }
}
