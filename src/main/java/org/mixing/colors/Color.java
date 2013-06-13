package org.mixing.colors;

public class Color {

    private final int number;
    private final Property property;

    public Color(int number, Property property) {
        this.number = number;
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (number != color.number) return false;
        if (property != color.property) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + property.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Color{" +
                "number=" + number +
                ", property=" + property +
                '}';
    }
}
