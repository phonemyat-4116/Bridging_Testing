package org.db_test;

public class Office {
    private int officeCode;
    private String city, state;

    public Office(int officeCode, String city, String state) {
        this.officeCode = officeCode;
        this.city = city;
        this.state = state;
    }

    public int getOfficeCode() {
        return officeCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeCode=" + officeCode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
