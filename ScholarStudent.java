package Smartex;

public class ScholarStudent extends Student {
    private double scholarshipAmount;

    public ScholarStudent(int studentId, String name, double marks, String section, double scholarshipAmount) throws InvalidMarksException {
        super(studentId, name, marks, section);
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public String calculateGrade() {
        double bonusMarks = marks + 5;
        if (bonusMarks > 100) bonusMarks = 100;
        if (bonusMarks >= 90) return "A";
        else if (bonusMarks >= 75) return "B";
        else if (bonusMarks >= 60) return "C";
        else if (bonusMarks >= 40) return "D";
        else return "F";
    }

    @Override
    public String getType() {
        return "Scholar Student";
    }
}