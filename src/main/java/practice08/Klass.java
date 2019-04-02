package practice08;

public class Klass {
    private Integer number = null;

    private Student leader = null;

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
        this.leader = leader;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) || ((o instanceof Klass) && (((Klass) o).getNumber() == getNumber()));
    }

}
