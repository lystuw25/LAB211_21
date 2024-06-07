
import java.util.*;

public class StudentList {

    private ArrayList<Student> studentList = new ArrayList<>();
    private Validation v = new Validation();
    private Scanner sc = new Scanner(System.in);
    String p1 = "Enter the id: ";
    String p2 = "Enter the name: ";
    String p3 = "Enter the semester: ";
    String p4 = "Enter the course (Java, .Net, C/C++): ";

    public void add() throws Exception {
        int size = 0;
        while (true) {
            while (true) {
                Student s = new Student();
                s.setId(v.checkInputInt(p1));
                s.setStudentName(v.checkInputString(p2));
                s.setSemester(v.checkInputInt(p3));
                s.setCourseName(v.checkInputString(p4));
                if (isValidStudent(s)) {
                    studentList.add(s);
                    System.out.println("Add success.");
                    size++;
                }
                if (size >= 4) break;
            }
            System.out.print("Do you want to continue(Y/N)?: ");
            if (!v.checkYN()) break;
        }
    }

    public Student findByID(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    public boolean isValidStudent(Student s1){
        for (Student s : studentList) {
            if(s.getId() == s1.getId()) return false;
        }
        return true;
    }
    

    public void findAndSort() throws Exception {
        String findName;
        while (true) {
            try {
                findName = v.checkInputString(p2);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StudentList a = findByPart(findName);
        if (a == null) {
            System.out.println("Not found.");
        } else {
            System.out.printf("%-5s|%-15s|%-10s|%-10s\n", "ID", "Name", "Semester", "Course");
            a.sort();
            a.displayStudent();
        }
    }

    public void sort() {
        Collections.sort(studentList, Comparator.comparing(Student::getStudentName));
    }

    public StudentList findByPart(String name) {
        StudentList result = new StudentList();
        boolean check = true;
        for (Student s : studentList) {
            if (s.getStudentName().contains(name)) {
                result.studentList.add(s);
                check = false;
            }
        }
        if (!check) return result;
        else return null;
    }

    public void updOrDel() throws Exception {
        int findNum = v.checkInputInt(p1);
        Student b = findByID(findNum);
        if (b == null) {
            System.out.println("Not found.");
        } else {
            System.out.print("Do you want to update (U) or delete (D) student? ");
            if (v.checkUD()) {
                b.setStudentName(v.checkInputString(p2));
                b.setSemester(v.checkInputInt(p3));
                b.setCourseName(v.checkInputString(p4));
                System.out.println("Update success.");
            } else {
                studentList.remove(b);
                System.out.println("Delele success.");
            }
        }
    }

    public void displayStudent() {
        for (Student s : studentList) {
            s.display();
        }
    }

    public void displayReport() {
        Map<String, Map<String, Integer>> report = new LinkedHashMap<>();
        for (Student s : studentList) {
            String name = s.getStudentName();
            String course = s.getCourseName();
            if (!report.containsKey(name)) {
                report.put(name, new HashMap<>());
            }
            Map<String, Integer> courses = report.get(name);
            if (!courses.containsKey(course)) {
                courses.put(course, 0);
            }
            courses.put(course, courses.get(course) + 1);
        }
        System.out.printf("%-15s|%-10s|%-10s\n", "Name", "Course", "Total Course");
        for (String nameKey : report.keySet()) {
            Map<String, Integer> courses = report.get(nameKey);
            for (String courseKey : courses.keySet()) {
                int totalCourses = courses.get(courseKey);
                System.out.printf("%-15s|%-10s|%-10s\n", nameKey, courseKey, totalCourses);
            }
        }
    }

}
