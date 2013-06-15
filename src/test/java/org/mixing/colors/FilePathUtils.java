package org.mixing.colors;

public class FilePathUtils {
    public static String getFilePathFrom(String fileName, Class<?> clazz) {
        String pathToFile = clazz.getPackage().getName().replace(".", "/") + "/" + fileName;
        return clazz.getClassLoader().getResource(pathToFile).getFile();
    }
}

