package com.bignerdranch.expandablerecyclerview.Model;

public class ParentType<T> {

    public Class<T> classModel;
    public int type;

    public ParentType(int type, Class<T> classModel) {
        this.classModel = classModel;
        this.type = type;
    }
}