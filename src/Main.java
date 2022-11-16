public class Main {

    public static void main(String[] args) {

        //RAW TYPES

        Comparable p1 = new Person("abc", 25);
        Comparable p2 = new Person("xyz", 30);


        Comparable e1=new Employee("abc", 2500);
        Comparable e2 = new Employee("xyz", 3000);

        System.out.println(max(p1, p2));

        System.out.println(max(e1, e2));

        System.out.println(max(p1, e1));
        System.out.println(maxwithGen(p1, e1)); //raw types are supported with generic


        //CONCRETE TYPES

        Person p3 = new Person("abc", 25);
        Person p4 = new Person("xyz", 30);


        Employee e3=new Employee("abc", 2500);
        Employee e4 = new Employee("xyz", 3000);

        System.out.println(max(p3, p4));

        System.out.println(max(e3, e4));

        System.out.println(max(p3, e4));
        System.out.println(maxwithGen(p3, e3)); //diff concrete types are supported with generic

    }

    public static <E extends Comparable<E>> E maxwithGen(E o1, E o2) {
        if (o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
    }

    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
    }
}
