package org.mixing.colors;

public class Customer {

    private final int name;

    public Customer(int name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (name != customer.name) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name=" + name +
                '}';
    }
}
