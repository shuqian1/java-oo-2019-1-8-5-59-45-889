package practice11;

import practice08.*;

import java.util.HashSet;

public class Klass {
    private int number;

    private Student leader = null;

    private HashSet<Student> students = new HashSet<>();

    private HashSet<Teacher> teachers = new HashSet<>();

    public Klass() {
    }

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

    public HashSet<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(HashSet<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getDisplayName() {
        return "Class " + getNumber();
    }

    public void appendMember(Student student) {
        students.add(student);
        notifyTeacher(student,"student");
    }

    public void appendTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean hasLeader() {
        return getLeader() != null;
    }

    public void assignLeader(Student leader) {
        if (isIn(leader)) {
            this.leader = leader;
            notifyTeacher(leader,"leader");
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

    public void notifyTeacher(Student student,String flag){
        if (flag.equals("student")){
            teachers.stream().filter(teacher -> teacher.isTeaching(student)).forEach(teacher -> teacher.welcomeNewStudent(student, this));
        }else if(flag.equals("leader")){
            teachers.stream().filter(teacher -> teacher.isTeaching(student)).forEach(teacher -> teacher.welcomeNewLeader(student, this));
        }
    }
}
