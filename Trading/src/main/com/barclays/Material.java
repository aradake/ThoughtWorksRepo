package com.barclays;

public class Material {

    private Length length;

    public Material() {
        this.length = new Length();
    }

    public Material(int meters,int centimeters) {
        this.length = new Length(meters,centimeters);
    }
    public void add(int length, char choice) {
        if (choice == 'm')
            this.length.add(length, 0);
        else
            this.length.add(0, length);
    }

    public void add(int meters,int centimeters ) {

            this.length.add(meters,centimeters);

    }

    public Length getLength() {
        return length;
    }
}
