package com.app.mode.demo.decorator.bean;

import com.app.mode.demo.decorator.base.MutilBean;

public class MultiData extends MutilBean {
    private int viewType = 0;
    private String name;

    public MultiData(int viewType, String name) {
        this.viewType = viewType;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int getType() {
        return this.viewType;
    }
}
