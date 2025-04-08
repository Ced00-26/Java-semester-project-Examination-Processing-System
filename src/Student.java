import java.util.*;

public class Student {
    private String name;
    private String id;
    private Map<String, Integer> scores = new LinkedHashMap<>();
    private double average;
    private String grade;
    private String recommendation;

    // Constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() { return name; }
    public String getId()   { return id; }
    public Map<String, Integer> getScores() { return scores; }
    public double getAverage() { return average; }
    public String getGrade() { return grade; }
    public String getRecommendation() { return recommendation; }

    // Setters for calculated fields
    public void setAverage(double avg) { this.average = avg; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setRecommendation(String rec) { this.recommendation = rec; }
}
