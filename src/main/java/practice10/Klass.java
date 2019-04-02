package practice10;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Scanner;

public class Klass {
    private int number;
    private Student leader = null;
    private HashSet<Student> students = new HashSet<>();

    public Klass(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    String getDisplayName() {
        return "Class " + getNumber();
    }

    public void assignLeader(Student leader) {
        if (isIn(leader)) {
            this.leader = leader;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    boolean isIn(Student student) {
        return students.stream().anyMatch(student::equals);
    }

    public Student getLeader() {
        return leader;
    }

    boolean hasLeader() {
        return getLeader() != null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof Klass) && (((Klass) obj).getNumber() == getNumber()));
    }

    void appendMember(Student student) {
        students.add(student);
    }
}
