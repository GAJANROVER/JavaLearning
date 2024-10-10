package com.example.myapp.service;

public interface CommonService<T> {

    T createOrUpdate(T t) throws Exception;

}
