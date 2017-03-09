package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Provalov on 08.03.2017.
 */
public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type) {
        switch (type) {
            case JPG: {
                return new JpgReader();

            }
            case PNG: {
                return new PngReader();

            }
            case BMP: {
                return new BmpReader();

            }
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
