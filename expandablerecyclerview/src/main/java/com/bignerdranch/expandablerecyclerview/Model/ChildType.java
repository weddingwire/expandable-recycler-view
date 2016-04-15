package com.bignerdranch.expandablerecyclerview.Model;

public class ChildType<T> {

    public Class<T> classModel;
    public int type;

    public ChildType(int type, Class<T> classModel) {
        this.classModel = classModel;
        this.type = type;
    }
}