import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. Show All\n3. Delete Student\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    dao.insertStudent(new Student(0, name, email));
                    break;
                case 2:
                    dao.getAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to Delete: ");
                    int id = sc.nextInt();
                    dao.deleteStudent(id);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
