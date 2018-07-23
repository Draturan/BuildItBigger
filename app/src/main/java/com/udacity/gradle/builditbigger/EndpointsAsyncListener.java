package com.udacity.gradle.builditbigger;

/**
 * Created by Simone on 23/07/2018 for BuildItBigger project
 */
public interface EndpointsAsyncListener<T> {
    void onPreTaskExecute();
    void onTaskComplete(T result);
}
