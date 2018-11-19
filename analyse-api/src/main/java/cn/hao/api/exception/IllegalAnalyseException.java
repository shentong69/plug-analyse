package cn.hao.api.exception;

/**
 * 自定义非法解析异常类
 * Created by Tianbohao on 2018/11/13.
 */
public class IllegalAnalyseException extends RuntimeException{


    private static final long serialVersionUID = 4687074536665419352L;

    public IllegalAnalyseException(){
        super();
    }

    public IllegalAnalyseException(String message){
        super(message);
    }
}
