package org.aidan.entity;

public class User {

    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "User{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
