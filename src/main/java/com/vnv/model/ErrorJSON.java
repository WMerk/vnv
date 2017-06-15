package com.vnv.model;

import java.util.Map;

public class ErrorJSON {

    public Integer status;
    public String error;
    public String message;
    public String timeStamp;
    public String trace;

    public ErrorJSON(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        Object errorTimeStamp = errorAttributes.get("timeStamp");
        if (errorTimeStamp!=null)
            this.timeStamp = errorTimeStamp.toString();
        this.trace = (String) errorAttributes.get("trace");
    }

}
