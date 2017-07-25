package com.yubraj.drools.factory;

/**
 * Created by ypokhrel on 7/25/2017.
 */
public interface ProcessingFactory<T, V> {
    T createProcessingObject(V inputObject);
}