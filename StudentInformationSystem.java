import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformationSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        addSampleData();  
        int choice;

        do {
            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("👋 Exiting program...");
                default -> System.out.println("❌ Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Student ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        students.add(new Student(id, name, age, grade, contact));
        System.out.println("✅ Student added successfully!");
    }


    static void addSampleData() {
    students.add(new Student("S001", "Trishna Sathe",     23, 85.5, "trishna@email.com"));
    students.add(new Student("S002", "Mayuri Sathe",      25, 92.0, "mayuri@email.com"));
    students.add(new Student("S003", "Priyanka Monde",    23, 88.5, "priyanka@email.com"));
    students.add(new Student("S004", "Pragati Deshmukh",  23, 88.0, "pragati@email.com"));
    students.add(new Student("S005", "Vaishnavi Bhalekar",24, 81.0, "vaishnavi@email.com"));
}

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No records found!");
            return;
        }

        System.out.printf("%-10s %-15s %-5s %-7s %-15s\n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("------------------------------------------------");

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID or Name: ");
        String key = sc.nextLine();
        boolean found = false;

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(key) ||
                s.getName().equalsIgnoreCase(key)) {

                System.out.println("🎯 Student Found:");
                s.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("❌ Student not found!");
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.print("New Name: ");
                s.setName(sc.nextLine());

                System.out.print("New Age: ");
                s.setAge(sc.nextInt());

                System.out.print("New Grade: ");
                s.setGrade(sc.nextDouble());
                sc.nextLine();

                System.out.print("New Contact: ");
                s.setContact(sc.nextLine());

                System.out.println("✅ Student updated!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                students.remove(s);
                System.out.println("🗑 Student deleted!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }
}
