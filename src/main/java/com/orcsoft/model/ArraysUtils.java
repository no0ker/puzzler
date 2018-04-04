package com.orcsoft.model;

public class ArraysUtils {
    public static byte[][] getCopy(byte[][] data) {
        byte[][] result = new byte[data.length][];
        for (int i = 0; i < data.length; i++) {
            result[i] = new byte[data[i].length];
            for (int j = 0; j < data[i].length; j++) {
                result[i][j] = data[i][j];
            }
        }
        return result;
    }

    public static byte[][] rotateLeft(byte[][] data) {
        int newWidth = data.length;
        int newHeight = data[0].length;
        byte[][] newData = new byte[newHeight][newWidth];

        for (int rowOy = 0; rowOy < data.length; rowOy++) {
            for (int rowOx = 0; rowOx < data[rowOy].length; rowOx++) {
                newData[newHeight - rowOx - 1][rowOy] = data[rowOy][rowOx];
            }
        }
        return newData;
    }
}
