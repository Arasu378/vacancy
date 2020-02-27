package com.arasu.vacancy.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CommonResponse {
    private Boolean isSuccess;
    private String message;
    private Object object;
    private List list;

    public CommonResponse(Boolean isSuccess, String message, Object object, List list) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.object = object;
        this.list = list;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
