package com.kafkaconsumer.dtos;

import java.io.Serializable;

/**
 *
 * @author Eze Q.
 * @version v1.0.1
 * @since v1.0.1
 */
public class GreetingDto implements Serializable {

    private String msg;
    private String name;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
