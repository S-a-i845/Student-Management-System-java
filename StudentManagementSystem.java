
    import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    // Constructor
    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Display method
    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);
    }

    // Add Student
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    // View Students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    // Update Student
    static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new Age: ");
                s.age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new Course: ");
                s.course = sc.nextLine();
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found.");
    }

    // Delete Student
    static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        Iterator<Student> it = students.iterator();
        boolean found = false;
        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found.");
    }
}


