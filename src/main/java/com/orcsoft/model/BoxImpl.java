package com.orcsoft.model;

public class BoxImpl implements BoxInterface {
    private final byte[][] data;
    private final byte elementSize;

    public BoxImpl(byte[][] data, byte elementSize) {
        this.data = data;
        this.elementSize = elementSize;
    }

    public BoxImpl() {
        this.data = new byte[BoxInterface.height][BoxInterface.width];
        this.elementSize = 0;
    }

    public BoxInterface putElement(ElementInterface element, int xOffset, int yOffset) {
        if (canPut(element, xOffset, yOffset)) {
            return doPut(ArraysUtils.getCopy(data), element, xOffset, yOffset);
        } else {
            return null;
        }
    }

    private BoxInterface doPut(byte[][] newData, ElementInterface element, int xOffset, int yOffset) {
        byte[][] elementData = element.getRawData();
        for (int oy = 0; oy < elementData.length; oy++) {
            for (int ox = 0; ox < elementData[oy].length; ox++) {
                if (elementData[oy][ox] != 0) {
                    newData[yOffset + oy][xOffset + ox] = element.getMetka();
                }
            }
        }
        return new BoxImpl(newData, (byte) (elementSize + 1));
    }

    private boolean canPut(ElementInterface element, int xOffset, int yOffset) {
        try {
            byte[][] elementData = element.getRawData();
            for (int oy = 0; oy < elementData.length; oy++) {
                for (int ox = 0; ox < elementData[oy].length; ox++) {
                    if (elementData[oy][ox] != 0 && data[yOffset + oy][xOffset + ox] != 0) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public String getStringData() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                stringBuilder.append(data[i][j]);
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public byte[][] getRawData() {
        return ArraysUtils.getCopy(data);
    }

    public byte getElementSize() {
        return elementSize;
    }
}
