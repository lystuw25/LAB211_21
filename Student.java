import java.util.*;
public class Student {
    private int id;
    private String studentName;
    private int semester;
    private String courseName;
    Scanner sc = new Scanner(System.in);
    public Student() {}
    public Student(int id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Must positive.");
        }
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) throws Exception {
        if (studentName.isEmpty()) {
            throw new Exception("Can't empty.");
        }
        if (!studentName.matches("[a-zA-Z ]+")) {
            throw new Exception("Invalid.");
        }
        this.studentName = studentName;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) throws Exception {
        if (semester <= 0) {
            throw new Exception("Must positive.");
        }
        this.semester = semester;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) throws Exception {
        if (courseName.isEmpty()) {
            throw new Exception("Can't empty.");
        }
        if (!courseName.equalsIgnoreCase("java") && !courseName.equalsIgnoreCase(".Net")
                && !courseName.equalsIgnoreCase("c/c++")) {
            throw new Exception("Invalid.");
        }
        this.courseName = courseName;
    }
    public Student create() throws Exception{
        while (true) {
            try {
                System.out.print("Enter the ID: ");
                setId(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                System.out.print("Enter the student name: ");
                setStudentName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                System.out.print("Enter the semester: ");
                setSemester(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                System.out.print("Enter the course name (Java / .Net / C/C++): ");
                setCourseName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Student(id, studentName, semester, courseName);
    }
    public Student update(int id) throws Exception {
        this.id = id;
        while (true) {
            try {
                System.out.print("Enter the student name: ");
                setStudentName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                System.out.print("Enter the semester: ");
                setSemester(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                System.out.print("Enter the course name: ");
                setCourseName(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Student(id, studentName, semester, courseName);
    }
    public void display() {
        System.out.printf("%-5s|%-15s|%-10s|%-10s\n", id, studentName, semester, courseName);
    }
}
