package practice10;

import java.util.HashSet;

public class Klass {
    private int number;
    private Student leader = null;
    private HashSet<Student> students = new HashSet<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void setStudents(HashSet<Student> students) {
        this.students = students;
    }

    public boolean hasLeader() {
        return getLeader() != null;
    }

    public String getDisplayName(){
        return "Class " + getNumber();
    }

    public void assignLeader(Student leader) {
        if (isIn(leader)) {
            this.leader = leader;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public boolean isIn(Student student) {
        return students.stream().anyMatch(student::equals);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof Klass) && (((Klass) obj).getNumber() == getNumber()));
    }

    public void appendMember(Student student) {
        students.add(student);
    }
}
