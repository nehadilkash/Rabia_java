public class Main {

    public static void main(String[] args) {
        GeometricObject circle1 = new Circle("red", true, 7);
        GeometricObject circle2 = new Circle("red", true, 6);

        System.out.println(GeometricObject.max(circle1, circle2));
    }
}
