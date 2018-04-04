package com.orcsoft.model;

public class ElementImpl implements ElementInterface {
    private final byte[][] data;
    private final byte metka;

    public ElementImpl(byte[][] data, byte metka) {
        this.data = ArraysUtils.getCopy(data);
        this.metka = metka;
    }

    public ElementInterface rotateRight() {
        return new ElementImpl(
                ArraysUtils.rotateLeft(
                        ArraysUtils.rotateLeft(
                                ArraysUtils.rotateLeft(getRawData()))), metka);
    }

    public ElementInterface rotateLeft() {
        return new ElementImpl(
                ArraysUtils.rotateLeft(getRawData()), metka);
    }


    public byte[][] getRawData() {
        return ArraysUtils.getCopy(data);
    }

    public String getStringData() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int rowOy = 0; rowOy < data.length; rowOy++) {
            for (int rowOx = 0; rowOx < data[rowOy].length; rowOx++) {
                stringBuilder.append(data[rowOy][rowOx]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public byte getMetka() {
        return metka;
    }
}
