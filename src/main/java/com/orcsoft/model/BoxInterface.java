package com.orcsoft.model;

public interface BoxInterface {
    int width = 4;
    int height = 4;
    BoxInterface putElement(ElementInterface element, int xOffset, int yOffset);
    String getStringData();
    byte[][] getRawData();
    byte getElementSize();
}
