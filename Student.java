
import java.util.*;

public class Student {

    private int id;
    private String studentName;
    private int semester;
    private String courseName;
    Scanner sc = new Scanner(System.in);

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(int id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Invalid id.");
        }
        this.id = id;
    }

    public void setStudentName(String studentName) throws Exception {
        if (studentName.isEmpty()) {
            throw new Exception("Can't empty.");
        }
        if (!studentName.matches("[a-zA-Z ]+")) {
            throw new Exception("Invalid name.");
        }

        this.studentName = studentName;
    }

    public void setSemester(int semester) throws Exception {

        if (semester <= 0) {
            throw new Exception("Invalid semester.");
        }

        this.semester = semester;
    }

    public void setCourseName(String courseName) throws Exception {

        if (courseName.isEmpty()) {
            throw new Exception("Invalid course.");
        }
        if (!courseName.equalsIgnoreCase("java")
                && !courseName.equalsIgnoreCase(".Net")
                && !courseName.equalsIgnoreCase("c/c++")) {
            throw new Exception("Invalid course.");
        }

        this.courseName = courseName;
    }

    public void display() {
        System.out.printf("%-5s|%-15s|%-10s|%-10s\n", id, studentName, semester, courseName);
    }
}
