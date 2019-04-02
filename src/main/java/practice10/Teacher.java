package practice10;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Teacher extends Person{
    private LinkedList<Klass> classes = new LinkedList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    public void setClasses(LinkedList<Klass> classes) {
        this.classes = classes;
    }

    private String getClassesDisplayName() {
        return "Class " + classes.stream().map(klass -> Integer.toString(klass.getNumber())).collect(Collectors.joining(", "));
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (getClasses().size() == 0 ? "No Class." : (getClassesDisplayName() + "."));
    }

    public boolean isTeaching(Student student){
        return getClasses().contains(student.getKlass());
    }

    public String introduceWith(Student student){
        return super.introduce() + " I am a Teacher. " + (isTeaching(student) ? "I teach " : "I don't teach " ) + student.getName() + ".";
    }
}
