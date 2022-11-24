package assignment3;

import java.util.Comparator;

public class GeometricObjectComparator implements Comparator<GeometricObject> {
    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        if (o1.getArea() - o2.getArea() > 0) {
            return 1;
        } else if (o1.getArea() - o2.getArea() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
