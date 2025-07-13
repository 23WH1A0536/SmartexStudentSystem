package Smartex;

//import java.util.*;

public class Student extends Record implements PersonInfo {
    protected int studentId;
    protected String name;
    protected double marks;
    protected String section;
    protected boolean isPassed;
    protected StringBuilder remarks;
    protected static int studentCount = 0;
    public static final String INSTITUTE_NAME = "Smartex Institute";

    public Student() {
        studentCount++;
        this.remarks = new StringBuilder();
    }

    public Student(int studentId, String name, double marks, String section) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.section = section;
        this.isPassed = marks >= 40;
        studentCount++;
        this.remarks = new StringBuilder();
    }

    public Student(Student s) {
        this.studentId = s.studentId;
        this.name = s.name;
        this.marks = s.marks;
        this.section = s.section;
        this.isPassed = s.isPassed;
        this.remarks = new StringBuilder(s.remarks);
        studentCount++;
    }

    public void printDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Section: " + section);
        System.out.println("Passed: " + isPassed);
        System.out.println("Remarks: " + (remarks.length() == 0 ? "None" : remarks));
    }

    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    public void addRemark(String remark) {
        if (remarks.length() > 0) remarks.append("; ");
        remarks.append(remark);
    }

    public void compareNames(String otherName) {
        System.out.println("Comparison using ==: " + (name == otherName));
        System.out.println("Comparison using equals(): " + name.equals(otherName));
        System.out.println("Comparison using equalsIgnoreCase(): " + name.equalsIgnoreCase(otherName));
    }

    public static int getTotalStudentCount() {
        return studentCount;
    }

    @Override
    public final void finalizeRecord() {
        System.out.println("Finalizing record for: " + name);
    }

    @Override
    public void displayBasicInfo() {
        System.out.println("ID: " + studentId + ", Name: " + name);
    }

    @Override
    public String getType() {
        return "Regular Student";
    }
}