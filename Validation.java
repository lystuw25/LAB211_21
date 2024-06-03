import java.util.*;
public class Validation {
    Scanner sc = new Scanner(System.in);
    public String checkInputString() throws Exception {
        while(true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                throw new Exception("Can't empty.");
            }else if(!result.matches("[a-zA-Z ]+")){
                throw new Exception("Can't contain special letter.");
            }
            else return result;
        }
    }
    public boolean checkYN() throws Exception{
        while(true){
            String a = sc.nextLine().trim();
            if(a.equalsIgnoreCase("y")) return true;
            if(a.equalsIgnoreCase("n")) return false;
            else throw new Exception("Invalid.");
        }
    }
    public boolean checkUD() throws Exception{
        while(true){
            String a = sc.nextLine().trim();
            if(a.equalsIgnoreCase("u")) return true;
            if(a.equalsIgnoreCase("d")) return false;
            else throw new Exception("Invalid.");
        }
    }
    public int checkInputInt() throws Exception {
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result<=0){
                    throw new Exception("Must be positive.");
                }else return result;
            }catch (Exception e){
                throw new Exception("Invalid. Try again: ");
            }
        }
    }
    
}
