package org.mixing.colors;

public class Color {

    private final int number;
    private final ColorType colorType;

    public Color(int number, ColorType colorType) {
        this.number = number;
        this.colorType = colorType;
    }

    public int getNumber() {
        return number;
    }

    public ColorType getColorType() {
        return colorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (number != color.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Color{" +
                "number=" + number +
                ", colorType=" + colorType +
                '}';
    }
}
