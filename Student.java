public class Student {
    private String studentId;
    private String name;
    private int age;
    private double grade;
    private String contact;

    public Student(String studentId, String name, int age, double grade, String contact) {
        this.studentId = studentId;
        this.name = name;
        setAge(age);
        setGrade(grade);
        this.contact = contact;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
    public String getContact() { return contact; }

    // Setters with validation
    public void setName(String name) { this.name = name; }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            System.out.println("❌ Age must be positive!");
    }

    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100)
            this.grade = grade;
        else
            System.out.println("❌ Grade must be between 0 and 100!");
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void display() {
        System.out.printf("%-10s %-15s %-5d %-7.2f %-15s\n",
                studentId, name, age, grade, contact);
    }
}
