package com.ltp.gradesubmission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ScoreValidator implements ConstraintValidator<Score, String> {

    List<String> scores = Arrays.asList(
            "A-", "A", "A+",
            "B-", "B", "B+",
            "C-", "C", "C+",
            "D-", "D", "D+",
            "F"
    );

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<String> optScore = scores.stream().filter(score -> score.equals(s)).findFirst();

        if (optScore.isPresent()) {
            return true;
        }

        return false;
    }
}
