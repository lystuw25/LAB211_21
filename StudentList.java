import java.util.*;
public class StudentList {
    private ArrayList<Student> studentList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addStudent(Student s){
        studentList.add(s);
    }
    public Student findByID(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }    
    public boolean checkValidStudent(Student s1){
        for (Student s : studentList) {
            if(s.equals(findByID(s1.getId())) ||
              (s.getId()==s1.getId() && !s.getStudentName().equalsIgnoreCase(s1.getStudentName()))){
                return false;
            }
        }
        return true;
    }
    public void sort(){
        Collections.sort(studentList, Comparator.comparing(Student::getStudentName));
    }
    public StudentList findByPart(String name){
        StudentList result = new StudentList();
        boolean check = true;
        for (Student s : studentList) {
            if(s.getStudentName().contains(name)){
                result.addStudent(s);
                check = false;
            }
        }
        if(!check) return result;
        else return null;
    }   
    public void displayStudent(){
        for (Student s : studentList) {
            s.display();
        }
    }   
    public void delete(int id){
        for (Student s : studentList) {
            if(s.equals(findByID(id))){
                studentList.remove(s);
                break;
            }
        }
    }
    public void updateStudent(Student s1) throws Exception{
        for (Student s : studentList) {
            if(s.equals(findByID(s1.getId()))){
                s.setStudentName(s1.getStudentName());
                s.setSemester(s1.getSemester());
                s.setCourseName(s.getCourseName());
                break;
            }
            
        }
    }
    public boolean checkValidUpdate(Student s1, int id){
        for (Student s : studentList) {
            if(s.equals(findByID(id))) continue;
            if(s.equals(findByID(s1.getId())) ||
              (s.getId() == s1.getId() && !s.getStudentName().equalsIgnoreCase(s1.getStudentName()))){
                return false;
            }
        }
        return true;
    }
    public Map<String, Map<String, Integer>> reportStudent(){
        Map<String, Map<String, Integer>> report = new LinkedHashMap<>();
        for (Student s : studentList) {
            String name = s.getStudentName();
            String course = s.getCourseName();
            if(!report.containsKey(name)){
                report.put(name, new HashMap<>());
            }
            Map<String, Integer> courses = report.get(name);
            if(!courses.containsKey(course)){
                courses.put(course,0);
            }
            courses.put(course, courses.get(course) + 1);
        }
        return report;
    }
    public static void displayReport(Map<String, Map<String, Integer>> report){
        for (String nameKey : report.keySet()) {
            Map<String, Integer> courses = report.get(nameKey);
            for (String courseKey : courses.keySet()) {
                int totalCourses = courses.get(courseKey);
                System.out.printf("%-15s|%-10s|%-10s\n", nameKey, courseKey, totalCourses);
            }
        }
    }
}
