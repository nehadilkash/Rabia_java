import java.util.Date;

public abstract class GeometricObject implements Comparable {
    private String color;
    private boolean filled;
    private Date date;

    public GeometricObject() {
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract double getArea();


    public abstract double getPerimeter();

    public static GeometricObject max(GeometricObject geometricObject1, GeometricObject geometricObject2) {
        if (geometricObject1.compareTo(geometricObject2) == 1)
            return geometricObject1;
        else
            return geometricObject2;
    }

    @Override
    public int compareTo(Object o) {
        GeometricObject object = (GeometricObject) o;
        if (this.getArea() > object.getArea()) {
            return 1;
        } else if (this.getArea() < object.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "GeometricObject{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", date=" + date +
                '}';
    }
}