
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExamProcessor {
    private Scanner scanner = new Scanner(System.in);
    private static final List<String> SUBJECTS =
        Arrays.asList("Mathematics", "Physics", "Chemistry", "Biology", "English");

    /**
     * 1. Read student details
     */
    public List<Student> readStudents(int n) {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter name of student #%d: ", i);
            String name = scanner.nextLine().trim();
            System.out.printf("Enter ID of student #%d: ", i);
            String id = scanner.nextLine().trim();
            students.add(new Student(name, id));
            System.out.println();
        }
        return students;
    }

    /**
     * 2. Read scores for each subject
     */
    public void readScores(Student s) {
        System.out.printf("Entering scores for %s (ID: %s)\n", s.getName(), s.getId());
        for (String subj : SUBJECTS) {
            int mark;
            while (true) {
                System.out.printf("  %s: ", subj);
                try {
                    mark = Integer.parseInt(scanner.nextLine().trim());
                    if (mark < 0 || mark > 100) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("    Invalid. Enter an integer 0–100.");
                }
            }
            s.getScores().put(subj, mark);
        }
        System.out.println();
    }

    /**
     * 3. Calculate average, grade & recommendation
     */
    public void calculateAverageAndGrade(Student s) {
        double sum = 0;
        for (int m : s.getScores().values()) sum += m;
        double avg = sum / s.getScores().size();
        s.setAverage(avg);

        String grade, rec;
        if (avg >= 70)      { grade = "A"; rec = "Excellent"; }
        else if (avg >= 60) { grade = "B"; rec = "Very Good"; }
        else if (avg >= 50) { grade = "C"; rec = "Good"; }
        else if (avg >= 40) { grade = "D"; rec = "Pass"; }
        else                { grade = "F"; rec = "Fail"; }

        s.setGrade(grade);
        s.setRecommendation(rec);
    }

    /**
     * 4. Display report card
     */
    public void displayReportCard(Student s) {
        System.out.println("==========================================");
        System.out.printf("Report Card — %s (ID: %s)\n", s.getName(), s.getId());
        System.out.println("------------------------------------------");
        for (Map.Entry<String, Integer> e : s.getScores().entrySet()) {
            System.out.printf("  %-12s : %3d\n", e.getKey(), e.getValue());
        }
        System.out.println("------------------------------------------");
        System.out.printf("  Average Score : %.2f\n", s.getAverage());
        System.out.printf("  Grade         : %s\n", s.getGrade());
        System.out.printf("  Recommendation: %s\n", s.getRecommendation());
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM uuuu"));
        System.out.printf("  Date Viewed   : %s\n", date);
        System.out.println("==========================================\n");
    }
}
