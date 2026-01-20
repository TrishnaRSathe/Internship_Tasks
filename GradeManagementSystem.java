import java.util.Scanner;

public class GradeManagementSystem {

    private static final int MAX_STUDENTS = 100;
    private static final int SUBJECT_COUNT = 5;

    private static String[] studentNames = new String[MAX_STUDENTS];
    private static double[][] studentMarks = new double[MAX_STUDENTS][SUBJECT_COUNT];
    private static int studentCount = 0;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n   GRADE MANAGEMENT SYSTEM   ");
            System.out.println("1. Add Student Marks");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Averages");
            System.out.println("4. Find Top Performers");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudentMarks();
                case 2 -> viewAllStudents();
                case 3 -> calculateAverages();
                case 4 -> findTopPerformers();
                case 5 -> generateReport();
                case 6 -> {
                    System.out.println("Thank you for using Grade Management System!");
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // 1️ Add Student
    private static void addStudentMarks() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student limit reached!");
            return;
        }

        System.out.println("\n=== ADD STUDENT MARKS ===");
        System.out.print("Enter Student Name: ");
        studentNames[studentCount] = sc.nextLine();

        String[] subjects = {"Mathematics", "Science", "English", "History", "Computer"};

        System.out.println("\nEnter marks for 5 subjects (out of 100):");
        for (int i = 0; i < SUBJECT_COUNT; i++) {
            while (true) {
                System.out.print(subjects[i] + ": ");
                double mark = sc.nextDouble();
                if (mark >= 0 && mark <= 100) {
                    studentMarks[studentCount][i] = mark;
                    break;
                } else {
                    System.out.println("Marks must be between 0 and 100!");
                }
            }
        }
        sc.nextLine();
        studentCount++;
        System.out.println(" Student marks added successfully!");
    }

    // 2️ View All Students
    private static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students found!");
            return;
        }

        System.out.printf("\n%-20s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Student Name", "Math", "Science", "English", "History", "Computer", "Average");
        System.out.println("-".repeat(100));

        for (int i = 0; i < studentCount; i++) {
            double avg = calculateAverage(i);
            System.out.printf("%-20s %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f %-10.2f\n",
                    studentNames[i],
                    studentMarks[i][0],
                    studentMarks[i][1],
                    studentMarks[i][2],
                    studentMarks[i][3],
                    studentMarks[i][4],
                    avg);
        }
    }

    // 3️ Calculate Averages
    private static void calculateAverages() {
        System.out.println("\n   STUDENT AVERAGES    ");
        for (int i = 0; i < studentCount; i++) {
            double avg = calculateAverage(i);
            System.out.printf("%-15s : Average = %.2f, Grade = %s\n",
                    studentNames[i], avg, getGrade(avg));
        }
    }

    // 4Top Performers
    private static void findTopPerformers() {
        System.out.println("\n TOP PERFORMERS:");

        for (int i = 0; i < studentCount; i++) {
            for (int j = i + 1; j < studentCount; j++) {
                if (calculateAverage(i) < calculateAverage(j)) {
                    swap(i, j);
                }
            }
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%d. %s - Average: %.2f\n",
                    i + 1, studentNames[i], calculateAverage(i));
        }
    }

    // 5️ Generate Report
    private static void generateReport() {
        System.out.println("\n  PERFORMANCE REPORT   ");
        System.out.println("Total Students: " + studentCount);

        String[] subjects = {"Mathematics", "Science", "English", "History", "Computer"};

        System.out.println("\n SUBJECT AVERAGES:");
        for (int i = 0; i < SUBJECT_COUNT; i++) {
            double sum = 0;
            for (int j = 0; j < studentCount; j++) {
                sum += studentMarks[j][i];
            }
            System.out.printf("• %s: %.2f\n", subjects[i], sum / studentCount);
        }

        int a = 0, b = 0, c = 0, d = 0, f = 0;
        for (int i = 0; i < studentCount; i++) {
            switch (getGrade(calculateAverage(i))) {
                case "A" -> a++;
                case "B" -> b++;
                case "C" -> c++;
                case "D" -> d++;
                default -> f++;
            }
        }

        System.out.println("\n GRADE DISTRIBUTION:");
        System.out.println("• A Grade: " + a + " students");
        System.out.println("• B Grade: " + b + " students");
        System.out.println("• C Grade: " + c + " students");
        System.out.println("• D Grade: " + d + " students");
        System.out.println("• F Grade: " + f + " students");
    }

    // Utility Methods
    private static double calculateAverage(int i) {
        double sum = 0;
        for (int j = 0; j < SUBJECT_COUNT; j++) {
            sum += studentMarks[i][j];
        }
        return sum / SUBJECT_COUNT;
    }

    private static String getGrade(double avg) {
        if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    private static void swap(int i, int j) {
        String tempName = studentNames[i];
        studentNames[i] = studentNames[j];
        studentNames[j] = tempName;

        double[] tempMarks = studentMarks[i];
        studentMarks[i] = studentMarks[j];
        studentMarks[j] = tempMarks;
    }
}
