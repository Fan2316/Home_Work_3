package objects;

public class Student {
    private long id;
    private String studentFIO, sex;
    private int idGroup;

    public Student(Long id, String studentFIO, String sex, int idGroup) {
        this.id = id;
        this.studentFIO = studentFIO;
        this.sex = sex;
        this.idGroup = idGroup;
    }

    public Student(String studentFIO, String sex, int idGroup) {
        this.studentFIO = studentFIO;
        this.sex = sex;
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "Студенты{" +
                id +
                ", '" + studentFIO + '\'' +
                ",'" + sex + '\'' +
                ", idGroup='" + idGroup + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentFIO() {
        return studentFIO;
    }

    public void setStudentFIO(String studentFIO) {
        this.studentFIO = studentFIO;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
