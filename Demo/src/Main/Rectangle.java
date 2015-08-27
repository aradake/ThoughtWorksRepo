package Main;

/**
 * Created by Owner on 8/24/2015.
 */
public class Rectangle {

    private int length;
    private int breadth;

    public Rectangle() {
    }

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double computeArea()
    {
        return this.length*this.breadth;
    }

    public double computePerimeter()
    {
        return 2*(this.length+this.breadth);
    }
}
