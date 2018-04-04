package com.orcsoft.model;

import java.util.Arrays;
import java.util.List;

public class BruteForcer {
    List<ElementImpl> elements = Arrays.asList(
            new ElementImpl(new byte[][]{{1, 0}, {1, 1}}, (byte) 1),
            new ElementImpl(new byte[][]{{1, 0}, {1, 1}}, (byte)2),
            new ElementImpl(new byte[][]{{1, 0}, {1, 1}}, (byte)3),
            new ElementImpl(new byte[][]{{1, 0}, {1, 1}}, (byte)4),
            new ElementImpl(new byte[][]{{1, 1}}, (byte)5),
            new ElementImpl(new byte[][]{{1, 1}}, (byte)6)
    );

    public void run() {
        run(new BoxImpl(), 0);
    }

    public void run(BoxInterface box, int i) {
        ElementImpl element = elements.get(i);

        for (int ox = 0; ox < BoxInterface.width; ox++) {
            for (int oy = 0; oy < BoxInterface.height; oy++) {

                BoxInterface boxNext = box.putElement(element, ox, oy);

                if (boxNext != null) {
                    if (i + 1 < elements.size()) {
                        // получилось вставить элемент. беремся за вставку следующего
                        run(boxNext, i + 1);
                    } else {
                        // получилось вставить последний элемент.
                        System.out.println(boxNext.getStringData());
                    }
                }

                boxNext = box.putElement(element.rotateLeft().rotateLeft(), ox, oy);

                if (boxNext != null) {
                    if (i + 1 < elements.size()) {
                        // получилось вставить элемент. беремся за вставку следующего
                        run(boxNext, i + 1);
                    } else {
                        // получилось вставить последний элемент.
                        System.out.println(boxNext.getStringData());
                    }
                }

                boxNext = box.putElement(element.rotateLeft().rotateLeft().rotateLeft(), ox, oy);

                if (boxNext != null) {
                    if (i + 1 < elements.size()) {
                        // получилось вставить элемент. беремся за вставку следующего
                        run(boxNext, i + 1);
                    } else {
                        // получилось вставить последний элемент.
                        System.out.println(boxNext.getStringData());
                    }
                }

            }
        }
    }
}
