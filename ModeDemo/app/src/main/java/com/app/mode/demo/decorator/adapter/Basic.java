package com.app.mode.demo.decorator.adapter;

import java.util.List;

public interface Basic<T> {


    List<T> getData();

    void setNewData(List<T> list);

    void addData(List<T> list);

    void addData(T t);
}
