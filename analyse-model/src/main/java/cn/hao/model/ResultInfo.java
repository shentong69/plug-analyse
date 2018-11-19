package cn.hao.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by Tianbohao on 2018/10/30.
 */
public class ResultInfo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("resultData")
    private List<Map<String, String>> resultData;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("resultType")
    private int resultType;

    public List<Map<String, String>> getResultData() {
        return resultData;
    }

    public void setResultData(List<Map<String, String>> resultData) {
        this.resultData = resultData;
    }

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }


    public static final class Builder {
        private ResultInfo result = new ResultInfo();

        private Builder() {
            this.result = new ResultInfo();
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setResultData(List<Map<String, String>> resultData) {
            this.result.resultData = resultData;
            return this;
        }

        public Builder setResultType(int resultType) {
            this.result.resultType = resultType;
            return this;
        }

        public ResultInfo build() {
            return result;
        }
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "resultData=" + resultData +
                ", resultType=" + resultType +
                '}';
    }
}
