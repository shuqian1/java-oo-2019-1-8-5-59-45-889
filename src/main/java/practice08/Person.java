package practice08;

public class Person extends practice01.Person{
    private int id;

    public Person(int id,String name, int age) {
        super(name, age);
        this.id = id;
    }

    public Person(String name, int age) {
        super(name, age);
    }
}
