package com.elec5620.commute.pojo;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author lishen
 * @Date 6/11/20 15:35
 **/
public class Result implements Serializable {

    private String status;
    private Object result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
