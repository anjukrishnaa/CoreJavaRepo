//import java.util.ArrayList;
import java.util.Scanner;

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
    private Student[] students ;
    int currentSize=0;
    int i;
   
    Scanner sc = new Scanner(System.in);
    public void addStudent(Student[] students){
        if(currentSize>=students.length)
        {
            System.out.println("Array is full");
            return;

        }
        System.out.println("Enter the id of the student: ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the student: ");
        String name = sc.next();
        System.out.println("Enter the roll number of the student: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        students [currentSize]= new Student(id, name, rollNo, marks);
        currentSize++;
        System.out.println("Students added");
    }
    
    public void deleteStudent(Student[] students){
        System.out.println("enter the roll no to delete");
        int rolldelete = sc.nextInt();
        boolean flag=false;
        if (currentSize==0){
            System.out.println("No students to delete");
            return;
        }else{
        for(i=0;i<currentSize;i++){
            //currentSize--;
            
            if(students[i].rollNo==rolldelete){
               // students[i] = null;
               flag=true;
               for(int j=i;j<currentSize;j++){
               students[j]=students[j+1];
                students[j+1]=null;
                
               }
               currentSize--;
               System.out.println("element deleted");
            }
        }

    }
}
        
   
    public void readStudent(Student[] students){
        if (currentSize==0){
            System.out.println("No students to display");
        }else{
            System.out.println("List of Students"+currentSize);
            for(i=0;i<currentSize;i++){
                //students[i].display(); 
                System.out.println("student id:"+students[i].id+"\nStudent name:"+students[i].name+"\nStudent rollNo:"+students[i].rollNo+"\nStudents marks:"+students[i].marks);

            }
            
       
    }
}
}

public class Test {
    public static void main(String[] args) {
        Student[] students =new Student[3];
        Scanner sc = new Scanner(System.in);
        StudentDetail sd= new StudentDetail();
        int option;

        
        do {
            System.out.println("1. Add student");
            System.out.println("2. Read student");
            System.out.println("3. Remove student");
            System.out.println("4. Exit");
             option = sc.nextInt();

            switch(option){
                case 1: sd.addStudent(students);
                        break;
                case 2: sd.readStudent(students);
                        break;
                case 3:sd.deleteStudent(students);
                        break;
                case 4: System.out.println("exit");
                        break;

                default:System.out.println("Invalid");
                        break;
            }
        }while(option!=4);
    }

}
