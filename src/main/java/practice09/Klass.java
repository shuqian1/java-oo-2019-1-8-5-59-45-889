package practice09;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Logger;

public class Klass {
    private Integer number = null;

    private Student leader = null;

    private HashSet<Student> students = new HashSet<>();

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public String getDisplayName(){
        return "Class " + getNumber();
    }

    public void assignLeader(Student leader){
        if(students.contains(leader)){
            this.leader = leader;
        }else {
            System.out.println("It is not one of us.");
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) || ((o instanceof Klass) && (((Klass) o).getNumber() == getNumber()));
    }

    public void appendMember(Student student){
        students.add(student);
    }

}
