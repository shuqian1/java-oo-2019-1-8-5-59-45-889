package practice07;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + (getKlass() == null ? "No Class." : getKlass().getDisplayName() + "." );
    }

    private boolean isTeaching(Student student){
        return student.getKlass() == getKlass();
    }

    public String introduceWith(Student student){
        return super.introduce() + " I am a Teacher. " + (isTeaching(student) ? "I teach " : "I don't teach " ) + student.getName() + ".";
    }
}
