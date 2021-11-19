package org.example;

public class Logger {
    final static org.apache.log4j.Logger l = org.apache.log4j.Logger.getLogger(org.apache.log4j.Logger.class);

    public void log(String msg){
        l.error(msg);
    }

    public void log(String msg, Exception err){
        l.error(msg,err);
    }
}
