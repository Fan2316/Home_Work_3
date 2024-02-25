package tables;


import objects.Student;
import utils.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class StudentTable extends AbsTable {
    private static final String groupSearch = "Developer";
    private final static String TABLE_NAME = "students";

    public StudentTable() {
        super(TABLE_NAME);
        columns = new HashMap<>();
        columns.put("id", "INT NOT NULL AUTO_INCREMENT PRIMARY KEY");
        columns.put("studentFIO", "varchar(50)");
        columns.put("sex", "varchar(3)");
        columns.put("idGroup", "int");
        create();
    }

    public ArrayList<Student> selectAll() {
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }

    private ArrayList<Student> selectByQuery(String sqlQuery) {
        ArrayList<Student> students = new ArrayList<>();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                students.add(new Student(
                        rs.getLong("id"),
                        rs.getString("studentFIO"),
                        rs.getString("sex"),
                        rs.getInt("idGroup")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public void insert(Student student) {
        String sqlQuery = String.format("INSERT INTO %s (studentFIO, sex, idGroup) " +
                        "VALUES ( '%s', '%s', '%d')",
                tableName,
                student.getStudentFIO(),
                student.getSex(),
                student.getIdGroup());
        db.executeRequest(sqlQuery);
    }

    public void selectAllStudents() {
        Tools.delimeter();
        System.out.print("Количество студентов:");
        final String sqlQuery = String.format("SELECT COUNT(*) FROM %s", tableName);
        select(sqlQuery);
    }

    public void selectAllFemaleStudents() {
        Tools.delimeter();
        System.out.println("Студентки:");
        final String sqlQuery = "SELECT studentFIO FROM students WHERE sex='жен'";
        select(sqlQuery);
    }

    public void selectAllGroupsWithCuratorsAndStudents() {
        Tools.delimeter();
        System.out.println("Информация о студентах, включая название группы и ФИО куратора:");
        final String sqlQuery = "SELECT students.id, students.studentFIO, students.sex, " +
                "group1.groupName, curator.curatorFIO" +
                " FROM students JOIN group1 ON students.idGroup=group1.id" +
                " JOIN curator ON group1.idCurator=curator.id ORDER BY students.id ASC;";
        select(sqlQuery);
    }

    public void selectSearchGroup() {
        Tools.delimeter();
        System.out.println("Студенты из группы Developer:");
        final String sqlQuery = String.format("SELECT studentFIO " +
                "FROM students WHERE idGroup=(SELECT id FROM group1 WHERE groupName='" + groupSearch + "')");
        select(sqlQuery);
    }
}
