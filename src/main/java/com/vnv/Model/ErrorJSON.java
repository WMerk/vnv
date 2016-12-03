package com.vnv.Model;

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
        Object timeStamp = errorAttributes.get("timeStamp");
        if (timeStamp!=null)
            this.timeStamp = timeStamp.toString();
        this.trace = (String) errorAttributes.get("trace");
    }

}
