package com.yubraj.drools.service;

/**
 * Created by ypokhrel on 7/25/2017.
 */
public interface Processor<T> {
    void process(T input);
}
