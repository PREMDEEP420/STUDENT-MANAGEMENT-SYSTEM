import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    // Student class
    static class Student {
        private String name;
        private int rollNumber;
        private String grade;
        private int age;

        public Student(String name, int rollNumber, String grade, int age) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollNumber=" + rollNumber +
                    ", grade='" + grade + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // List to store students
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Remove a student by roll number
    public boolean removeStudent(int rollNumber) {
        return students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Edit student details
    public boolean editStudent(int rollNumber, String newName, String newGrade, int newAge) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.setName(newName);
            student.setGrade(newGrade);
            student.setAge(newAge);
            return true;
        }
        return false;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // Main method for console-based interface
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nStudent Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search Student");
                System.out.println("4. Edit Student");
                System.out.println("5. Display All Students");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNumber = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        sms.addStudent(new Student(name, rollNumber, grade, age));
                        break;

                    case 2:
                        System.out.print("Enter roll number to remove: ");
                        int rollToRemove = Integer.parseInt(scanner.nextLine());
                        if (sms.removeStudent(rollToRemove)) {
                            System.out.println("Student removed successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter roll number to search: ");
                        int rollToSearch = Integer.parseInt(scanner.nextLine());
                        Student foundStudent = sms.searchStudent(rollToSearch);
                        if (foundStudent != null) {
                            System.out.println("Student found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter roll number to edit: ");
                        int rollToEdit = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new grade: ");
                        String newGrade = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = Integer.parseInt(scanner.nextLine());
                        if (sms.editStudent(rollToEdit, newName, newGrade, newAge)) {
                            System.out.println("Student details updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        sms.displayAllStudents();
                        break;

                    case 6:
                        System.out.println("Exiting application.");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
