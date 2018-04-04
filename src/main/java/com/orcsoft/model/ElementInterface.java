package com.orcsoft.model;

public interface ElementInterface {
    ElementInterface rotateRight();
    ElementInterface rotateLeft();
    byte[][] getRawData();
    String getStringData();
    byte getMetka();
}
