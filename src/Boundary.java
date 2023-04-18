import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public class Boundary {
    private ArrayList<Double> x1;
    private ArrayList<Double> y1;
    private double price;

    public Boundary(ArrayList<Double> x1, ArrayList<Double> y1, double price) {
        this.x1 = x1;
        this.y1 = y1;
        this.price = price;
    }

    public boolean contains(double x, double y) {
        // Create a Polygon object representing the boundary
        Polygon polygon = new Polygon();
        for (int i = 0; i < x1.size(); i++) {
            polygon.getPoints().addAll(x1.get(i), y1.get(i));
        }


        // Use the contains() method to check if the point is inside the polygon
        return polygon.contains(x, y);
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        Polygon polygon = new Polygon();
        for (int i = 0; i < x1.size(); i++) {
            polygon.getPoints().addAll(x1.get(i), y1.get(i));
        }
        double[] vertices = polygon.getPoints().stream().mapToDouble(Double::doubleValue).toArray();

        // apply the shoelace formula to calculate the area
        double area = 0;
        for (int i = 0; i < vertices.length; i += 2) {
            double x1 = vertices[i];
            double y1 = vertices[i + 1];
            double x2 = vertices[(i + 2) % vertices.length];
            double y2 = vertices[(i + 3) % vertices.length];
            area += x1 * y2 - x2 * y1;
        }
        area /= 2;

        return Math.abs(area * 10000) / (62 * 62);
    }

    @Override
    public String toString() {
        return "Boundary{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", price=" + price +
                '}';
    }
}

