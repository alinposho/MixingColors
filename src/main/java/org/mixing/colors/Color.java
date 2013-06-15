package org.mixing.colors;

public class Color implements Comparable<Color> {

    private final int id;
    private final ColorType colorType;

    public Color(int id, ColorType colorType) {
        assert id > 0;
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
        if (colorType != color.colorType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (colorType != null ? colorType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", colorType=" + colorType +
                '}';
    }

    @Override
    public int compareTo(Color other) {
        return id - other.id;
    }
}
