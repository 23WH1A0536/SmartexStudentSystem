package Smartex;

import java.util.*;

public class StudentApp {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Student().welcomeMessage();

        while (true) {
            System.out.println("\n--- Welcome to Smartex Student System ---");
            System.out.println("1. Add Student\n2. Display Student Details\n3. Append Remarks\n4. Calculate Grade\n5. Compare Names\n6. Simulate Exception\n7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: appendRemark(); break;
                case 4: calculateGrade(); break;
                case 5: compareNames(); break;
                case 6: simulateException(); break;
                case 7: System.out.println("Exiting system. Thank you!"); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter Section (A/B/C): ");
            String section = sc.nextLine();

            Student s = new Student(id, name, marks, section);
            students.add(s);
            System.out.println("Student added successfully!");
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student s : students) {
            s.printDetails();
            System.out.println();
        }
    }

    private static void appendRemark() {
        System.out.print("Enter Student ID to update remarks: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.studentId == id) {
                System.out.print("Enter your remark: ");
                String remark = sc.nextLine();
                s.addRemark(remark);
                System.out.println("Remark added successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void calculateGrade() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.studentId == id) {
                System.out.println("Grade: " + s.calculateGrade());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void compareNames() {
        System.out.print("Enter first student name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        System.out.println("Comparison using ==: " + (name1 == name2));
        System.out.println("Comparison using equals(): " + name1.equals(name2));
        System.out.println("Comparison using equalsIgnoreCase(): " + name1.equalsIgnoreCase(name2));
    }

    private static void simulateException() {
        try {
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            System.out.print("Enter divisor: ");
            int div = sc.nextInt();
            int res = num / div;
            System.out.println("Result: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}