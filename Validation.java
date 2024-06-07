import java.util.*;
public class Validation {
    Scanner sc = new Scanner(System.in);
    public String checkInputString(String p) throws Exception {
        while (true) {
            try{
                System.out.print(p);
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    throw new Exception("Invalid input.");
                }else return result;
            }catch(Exception e){
                throw new Exception("Invalid.");
            }
        }
    }
    public boolean checkYN() throws Exception {
        while (true) {
            String a = sc.nextLine().trim();
            if (a.equalsIgnoreCase("y")) return true;
            if (a.equalsIgnoreCase("n")) return false; 
            else throw new Exception("Invalid.");
        }
    }
    public boolean checkUD() throws Exception {
        while (true) {
            String a = sc.nextLine().trim();
            if (a.equalsIgnoreCase("u")) return true;
            if (a.equalsIgnoreCase("d")) return false;
            else throw new Exception("Invalid.");
        }
    }
    public int checkInputInt(String p) throws Exception {
        while (true) {
            try {
                System.out.print(p);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    throw new Exception("Must be positive.");
                } else return result;
            } catch (Exception e) {
                throw new Exception("Invalid.");
            }
        }
    }
}
