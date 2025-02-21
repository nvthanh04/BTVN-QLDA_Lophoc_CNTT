import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String FirstName, LastName, Birthdate, Address, Class;
    double oop, QLDA, HM, CSDL, App;

    public Student(String FirstName, String LastName, String Birthdate, String Address, String Class, double  oop, double QLDA, double HM, double CSDL, double App)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthdate = Birthdate;
        this.Address = Address;
        this.Class = Class;
        this.oop = oop;
        this.QLDA = QLDA;
        this.HM = HM;
        this.CSDL = CSDL;
        this.App = App;
    }

    public double getDiemTB() {
        return (oop + QLDA + HM + CSDL + App)/5;
    }

    public void ThongTin() {
        System.out.println(LastName + " " + FirstName + " - Nam sinh: " + Birthdate + " - Dia chi: " + Address + " - Lop: " + Class);
    }
}

class ClassRoom {
    String ClassName;
    ArrayList<Student> students = new ArrayList<>();

    public ClassRoom(String ClassName)
    {
        this.ClassName = ClassName;
    }

    public String getClassName() 
    {
        return ClassName;
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public ArrayList<Student> Student(){
        return students;
    }
    
    public void displayStudents()
    {
        System.out.println("Danh sach Sinh Vien lop: "+ ClassName);
        if(students.isEmpty())
        {
            System.out.println("Không có học sinh nào trong lớp này");
        }
        else{
            for(Student s : students)
                s.ThongTin();
        }
        System.out.println("---------------------------------------------");
    }

    public void rankCore() {
        int A = 0, B = 0, C =0, D = 0, lessD = 0;

        for(Student student : students)
        {
            double tb = student.getDiemTB();
            if (tb >= 8.5) A++;
            else if (tb >= 7.0) B++;
            else if (tb >= 5.5) C++;
            else if (tb >= 4.0) D++;
            else lessD++;
        }

        System.out.println("So sinh viên có diem A: " + A);
        System.out.println("So sinh viên có diem B: " + B);
        System.out.println("So sinh viên có diem C: " + C);
        System.out.println("So sinh viên có diem D: " + D);
        System.out.println("So sinh viên có diem lessD: " + lessD);
    }
}
public class BTVN {
    public static void main(String[] args)
    {
        ArrayList<ClassRoom> classRooms = new ArrayList<>();

        ClassRoom class1 = new ClassRoom("HTTT3");
        ClassRoom class2 = new ClassRoom("HTTT4");

        classRooms.add(class1);
        classRooms.add(class2);

        class1.addStudent(new Student("John", "Doe", "2000-05-15", "123 Street", "HTTT3", 9.5, 8.8, 9.2, 8.4, 9.0));
        class1.addStudent(new Student("Jane", "Smith", "2001-07-20", "456 Avenue", "HTTT3", 8.0, 7.5, 7.0, 8.5, 8.9));
        class2.addStudent(new Student("Mark", "Lee", "2002-08-22", "789 Road", "HTTT4", 6.5, 6.0, 7.0, 5.5, 6.0));

        System.out.println("Danh sach cac lop hoc: " + " ");
        for (ClassRoom c : classRooms) {
            System.out.println( c.getClassName());
        }

        Scanner scanner = new Scanner(System.in);
        String classCode;
        boolean ktra = false;
        boolean isContinue = false;

        do{
            do{
                System.out.println("Nhap lop ban muon xem diem: ");
                classCode = scanner.nextLine();
    
                for(ClassRoom c : classRooms){
                    if(c.getClassName().equalsIgnoreCase(classCode)) // so sánh chuỗi
                    {
                        ktra = true;
                        c.rankCore();
                        c.displayStudents();
                        break;
                    }
                }
                if(!ktra)
                {
                    System.out.println("Lop khong ton tai! Vui long nhap lai");
                }
    
            }while(!ktra);

            System.out.println("Ban co muon tiep tuc hay khong (Y/N): ");
            String answer = scanner.nextLine().trim();
            isContinue = answer.equalsIgnoreCase("Y");
            
        }while(isContinue);
    }
}