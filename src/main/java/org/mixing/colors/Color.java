package org.mixing.colors;

public class Color {

    private final int id;
    private final ColorType colorType;

    public Color(int id, ColorType colorType) {
        this.id = id;
        this.colorType = colorType;
    }

    public int getId() {
        return id;
    }

    public ColorType getColorType() {
        return colorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (id != color.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", colorType=" + colorType +
                '}';
    }
}
