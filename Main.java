import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentList s = new StudentList();
        Validation v = new Validation();
        int choice, size = 0;
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGAMENT");
            System.out.println("\t1.Create");
            System.out.println("\t2.Find and sort");
            System.out.println("\t3.Update/Delete");
            System.out.println("\t4.Report");
            System.out.println("\t5.Exit program");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: //create
                    while (true) {
                        while (true) {
                            Student s1 = new Student();
                            boolean isAdded = s.checkValidStudent(s1.create());
                            if (isAdded) {
                                s.addStudent(s1);
                                System.out.println("Add successfully.");
                                size++;
                            }else{
                                System.out.println("Duplicate or Invalid.");
                            }
                            if(size>=10) break;
                        }
                        System.out.print("Do you want to continue(Y/N)?: ");
                        if (!v.checkYN()) break;
                    }
                    break;
                case 2: //find/sort
                    String findName;
                    while(true){
                        try{
                            System.out.print("Enter student name or part of name: ");
                            findName = v.checkInputString();
                            break;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    StudentList a = s.findByPart(findName);
                    if(a==null){
                        System.out.println("Not found.");
                    }else{
                        System.out.printf("%-5s|%-15s|%-10s|%-10s\n", "ID", "Name", "Semester", "Course");
                        a.sort();
                        a.displayStudent();
                    }
                    break;
                    
                case 3: //update/delete
                    int findNum;
                    while(true){
                        try{
                            System.out.print("Enter the ID: ");
                            findNum = v.checkInputInt();
                            break;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    Student b = s.findByID(findNum);
                    if(b==null){
                        System.out.println("Not found.");
                    }else{
                        System.out.println("Do you want to update (U) or delete (D) student? ");
                        if(v.checkUD()){
                            Student s2 = new Student();
                            boolean isUpdated = s.checkValidUpdate(s2.update(findNum),findNum);
                            if(isUpdated){
                                s.updateStudent(s2);
                                System.out.println("Update successfully.");
                            }else{
                                System.out.println("Duplicate or invalid.");
                            }
                        }else{
                            s.delete(findNum);
                            System.out.println("Delele success.");
                        }
                    }
                    break;
                case 4: //report
                    System.out.printf("%-15s|%-10s|%-10s\n", "Name", "Course", "Total Course");
                    Map<String, Map<String, Integer>> report = s.reportStudent();
                    StudentList.displayReport(report);
                    break;
                case 5: //end
                    System.out.println("-===END===-");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}
