
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentList s = new StudentList();
        int choice = 0;
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
                    s.add();
                    break;
                case 2: //find/sort
                    s.findAndSort();
                    break;
                case 3: //update/delete
                    s.updOrDel();
                    break;
                case 4: //report
                    s.displayReport();
                    break;
                case 5: //end
                    System.out.println("-===END===-");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
