package org.example.caching;

public interface LiveTimeChecker {
    long timeToLive = 60000; // after that time checking cache will replace old one (in millis) 1 min
    default boolean checkLiveTime(long createdTime){
        if (createdTime !=0){
            return (System.currentTimeMillis() > createdTime + timeToLive);
        }
        return false;
    }
}
