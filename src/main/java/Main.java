import db.MySQLConnector;
import objects.Curator;
import objects.Group;
import objects.Student;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;
import utils.Tools;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {

            StudentTable studentTable = new StudentTable();
            GroupTable groupTable = new GroupTable();
            CuratorTable curatorTable = new CuratorTable();
            ArrayList<Student> students = studentTable.selectAll();

            if (students.size() < 15) {
                studentTable.insert(new Student("Антонов Антон Антонович", "муж", 1));
                studentTable.insert(new Student("Борисова Божена Борисовна", "жен", 2));
                studentTable.insert(new Student("Вадимов Вадим Вадимович", "муж", 3));
                studentTable.insert(new Student("Гордеева Галина Гордеевна", "жен", 1));
                studentTable.insert(new Student("Денисов Денис Денисович", "муж", 2));
                studentTable.insert(new Student("Ефремова Елена Ефремовна", "жен", 3));
                studentTable.insert(new Student("Жданов Жаргал Жданович", "муж", 1));
                studentTable.insert(new Student("Захарова Зинаида Захаровна", "жен", 2));
                studentTable.insert(new Student("Иванов Иван Иванович", "муж", 3));
                studentTable.insert(new Student("Кузьмина Кира Кузьминична", "жен", 1));
                studentTable.insert(new Student("Львов Лев Львович", "муж", 2));
                studentTable.insert(new Student("Максимова Майя Максимовна", "жен", 3));
                studentTable.insert(new Student("Назаров Назар Назарович", "муж", 1));
                studentTable.insert(new Student("Ольгина Ольга Олеговна", "жен", 2));
                studentTable.insert(new Student("Петров Пётр Петрович", "муж", 3));
            }

            students = studentTable.selectAll();

            for (Student tmp : students) {
                System.out.println(tmp.toString());
            }

            Tools.delimeter();
            ArrayList<Group> groups = groupTable.selectAll();
            if (groups.size() < 3) {
                groupTable.insert(new Group(1, "QA", 101));
                groupTable.insert(new Group(2, "Developer", 102));
                groupTable.insert(new Group(3, "Data Analyst", 103));
            }

            groups = groupTable.selectAll();

            for (Group tmp : groups) {
                System.out.println(tmp.toString());
            }

            Tools.delimeter();
            ArrayList<Curator> curators = curatorTable.selectAll();
            if (curators.size() < 4) {
                curatorTable.insert(new Curator(101, "Родионова Роза Родионовна"));
                curatorTable.insert(new Curator(102, "Семёнов Семён Семёнович"));
                curatorTable.insert(new Curator(103, "Трофимова Таисия Трофимовна"));
                curatorTable.insert(new Curator(104, "Ульянов Ульян Ульянович"));
            }

            curators = curatorTable.selectAll();

            for (Curator tmp : curators) {
                System.out.println(tmp.toString());
            }

            groupTable.updateIdByName("QA", 104, "group1");

            studentTable.selectAllStudents();
            studentTable.selectAllFemaleStudents();
            groupTable.selectAllGroupsWithCurators();
            studentTable.selectAllGroupsWithCuratorsAndStudents();
            studentTable.selectSearchGroup();

        } finally {
            MySQLConnector.close();
        }
    }
}