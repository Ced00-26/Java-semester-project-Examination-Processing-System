import java.util.*;

public class Main {
    public static void main(String[] args) {
        ExamProcessor proc = new ExamProcessor();
        System.out.println("=== Examination Processing System ===\n");

        // 1. Read details of 10 students
        List<Student> students = proc.readStudents(10);

        // 2–4 for each student
        for (Student s : students) {
            proc.readScores(s);
            proc.calculateAverageAndGrade(s);
            proc.displayReportCard(s);
        }

        System.out.println("All report cards generated. Thank you.");
    }
}
