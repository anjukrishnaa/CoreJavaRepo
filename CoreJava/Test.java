import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


class Student{
    String name;
    int roll_no;
    int marks;
    int branchid;

   public Student(String name, int roll_no, int marks,int branchid){

        this.name = name;
        this.roll_no = roll_no;
        this.marks = marks;
        this.branchid=branchid;
    }



}


class StudentDetail<students> {
    private List<Student> studentlist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Connection con = null;

    StudentDetail() {




        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            } catch (SQLException ex) {
                System.out.println("Failed to create database Connection");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Not Found");
        }


    }


    public void addStudent() throws SQLException {
        try {

            System.out.println("Enter the name of the student: ");
            String name = sc.next();
            System.out.println("Enter the roll number of the student: ");
            int roll_no = sc.nextInt();
            System.out.println("Enter the marks of the student: ");
            int marks = sc.nextInt();
            System.out.println("Enter the branch id");
            int branchid = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("Insert into school.student(name,roll_no,marks,branchid)values (?,?,?,?);");
            ps.setString(1, name);

            ps.setInt(2, roll_no);
            ps.setInt(3, marks);
            ps.setInt(4, branchid);
            int rowupdate= ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in inserting in student" + e.getMessage());
        }


    }

    public void deleteStudent() throws SQLException {
        try{
            System.out.println("Enter the roll no which you want to delete");
            int rNo = sc.nextInt();
        PreparedStatement ps = con.prepareStatement("delete from student where roll_no=?");
        ps.setInt(1, rNo);
        int rowsDeleted= ps.executeUpdate();
        if(rowsDeleted>0){
            System.out.println("Student deleted successfully");
        }else{
            System.out.println("No student was found with given rollno");
        }

        } catch (SQLException e) {
             System.out.println("Error in deleting student"+e.getMessage());
         }

    }


    public void readStudent() throws SQLException{

        try {

            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("Select * from Student");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") + " ID: " + rs.getInt("id")
                        + " Roll NO: " + rs.getInt("roll_no") +" Marks: " + rs.getInt("marks")
                        + " Branch id: " + rs.getInt("branchid"));

            }
        } catch (SQLException e) {
            System.out.println("error in retriviewing student"+e.getMessage());
        }
    }

}
    public class Test {
        public static void main(String[] args) throws SQLException {
            ArrayList<Student> studentlist = new ArrayList<>();

            Scanner sc = new Scanner(System.in);
            StudentDetail sd = new StudentDetail();
            int option;


            do {
                System.out.println("1. Add student\n 2. Read student \n 3. Remove student \n 4. Exit");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        sd.addStudent();
                        break;
                    case 2:
                        sd.readStudent();
                        break;
                    case 3:
                        sd.deleteStudent();
                        break;
                    case 4:
                        System.out.println("exit");
                        break;

                    default:
                        System.out.println("Invalid");
                        break;
                }
            } while (option != 4);
        }

    }

