package com.ltp.gradesubmission;

import com.ltp.gradesubmission.validation.annotations.Score;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Grade {
    @NotBlank(message = "Name can not be blank")
    private String name;

    public Grade(String name, String subject, String score) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    @NotBlank(message = "Subject can not be blank")
    private String subject;

    @Score(message = "Score must be a letter grade")
    private String score;
    private String id;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
