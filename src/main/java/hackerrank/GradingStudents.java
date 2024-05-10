package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream()
                .map(grade -> {
                    if (grade < 38) {
                        return grade;
                    }
                    int nextMultipleOfFive = (grade + 4) / 5 * 5;
                    if (nextMultipleOfFive - grade < 3) {
                        return nextMultipleOfFive;
                    } else {
                        return grade;
                    }
                })
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33);
        System.out.println(gradingStudents(grades));
    }
}
