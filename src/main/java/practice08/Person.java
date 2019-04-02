package practice08;

public class Person extends practice01.Person{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(int id, String name, int age) {
        super(name, age);
        this.id = id;
    }

    public Person(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof Person) && (((Person) obj).getId() == getId()));
    }
}
