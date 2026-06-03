package service;
import model.Result;
import java.util.List;

public class GradeService {

    public double calculateAverage(List<Result> results) {
        return results.stream()
                      .mapToInt(Result::getMarks)
                      .average()
                      .orElse(0.0);
    }

    public String getGrade(double average) {
        if (average >= 90) return "O (Outstanding)";
        else if (average >= 75) return "A (Excellent)";
        else if (average >= 60) return "B (Good)";
        else if (average >= 50) return "C (Average)";
        else return "F (Fail)";
    }
}