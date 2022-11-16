public class Person implements Comparable<Person> {

    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public int compareTo(Object o) {
//        Person person = (Person) o;
//        if (this.age > person.getAge())
//            return 1;
//        else if (this.age == person.getAge())
//            return 0;
//        else
//            return -1;
//    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge())
            return 1;
        else if (this.age == o.getAge())
            return 0;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
