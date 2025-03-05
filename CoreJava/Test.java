import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Student{
    int id;
    String name;
    int rollNo;
    int marks;

   public Student(int id, String name, int rollNo, int marks){
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
//public void display()
//{
    //System.out.println("student id:"+id+"\nStudent name:"+name+"\nStudent rollNo:"+rollNo+"\nStudents marks:"+marks);
//}


}

class StudentDetail<students>{
    private List<Student> studentlist =new ArrayList<>();

   
    Scanner sc = new Scanner(System.in);
    public void addStudent(){

        System.out.println("Enter the id of the student: ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the student: ");
        String name = sc.next();
        System.out.println("Enter the roll number of the student: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        studentlist.add( new Student(id, name, rollNo, marks));
        System.out.println("Students added");

    }
    
    public void deleteStudent() {
        System.out.println("Enter the parameter which you would like to remove: ");
        int rNo = sc.nextInt();
        List<Student> updatedList = studentlist.stream()
                .filter(student -> student.rollNo != rNo).collect(Collectors.toList());

        if (updatedList.size() == studentlist.size()) {
            System.out.println("No students deleted");

        } else {
            studentlist = updatedList;
            System.out.println("student deleted successfully");
        }



    }

        
   
    public void readStudent(){
        if (studentlist.isEmpty()){
            System.out.println("No students to display .list is empty");
        }

        for(Student student:studentlist){
            //students[i].display();
            System.out.println("student id:"+student.id+"\nStudent name:"+student.name+"\nStudent rollNo:"+student.rollNo+"\nStudents marks:"+student.marks);

        }
    }
}


public class Test{
    public static void main(String[] args) {
       ArrayList<Student> studentlist =new ArrayList<>();
        //Student[] students =new Student[3];
        Scanner sc = new Scanner(System.in);
        StudentDetail sd= new StudentDetail();
        int option;

        
        do {
            System.out.println("1. Add student\n 2. Read student \n 3. Remove student \n 4. Exit");
             option = sc.nextInt();

            switch(option){
                case 1: sd.addStudent();
                        break;
                case 2: sd.readStudent();
                        break;
                case 3:sd.deleteStudent();
                        break;
                case 4: System.out.println("exit");
                        break;

                default:System.out.println("Invalid");
                        break;
            }
        }while(option!=4);
    }

}
