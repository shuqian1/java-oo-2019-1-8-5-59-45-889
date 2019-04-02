package practice11;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Teacher extends Person{
    private LinkedList<Klass> classes = new LinkedList<>();

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes.addAll(classes);
        this.classes.forEach(klass -> klass.appendTeacher(this));
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }


    public String getClassesDisplayName() {
        return "Class " + classes.stream().map(klass -> Integer.toString(klass.getNumber())).collect(Collectors.joining(", "));
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (getClasses().size() == 0 ? "No Class." : (getClassesDisplayName() + "."));
    }

    public boolean isTeaching(Student student) {
        return getClasses().stream().anyMatch(klass -> klass.isIn(student));
    }

    public String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. I " + (isTeaching(student) ? "" : "don't ") + "teach " + student.getName() + ".";
    }

    public void welcomeNewStudent(Student student, Klass klass) {
        System.out.println("I am " + getName() + ". I know " + student.getName() + " has joined " + klass.getDisplayName() + ".");
    }

    public void welcomeNewLeader(Student student, Klass klass) {
        System.out.println("I am " + getName() + ". I know " + student.getName() + " become Leader of " + klass.getDisplayName() + ".");
    }
}
