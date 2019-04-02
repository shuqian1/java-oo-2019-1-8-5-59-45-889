package practice08;

public class Student extends Person{
    private Klass klass;

    private Student leader;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public boolean isLeader(){
        return getKlass().getLeader() != null  && getKlass().getLeader().getName().equals(getName());
    }


    @Override
    public String introduce() {
        return super.introduce() +  " I am a Student." + (isLeader() ? " I am Leader of " : " I am at ") + getKlass().getDisplayName() + ".";
    }
}
