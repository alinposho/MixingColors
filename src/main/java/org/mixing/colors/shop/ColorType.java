package org.mixing.colors.shop;

public enum ColorType {
    GLOSSY("G"), MATTE("M");

    private String value;

    ColorType(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
