package com.zk.spring.model;

import org.springframework.context.annotation.Scope;

@org.springframework.stereotype.Component("msgBean")
@Scope("desktop")
public class SimpleMessageBean {
 
    private String msg;
     
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}