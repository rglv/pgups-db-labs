package ru.pgups.ivs.labs.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class Task {
    private long id;

    private long studentId;
    private long labId;

    private Date taskGiven;
    private Date taskFinished;

    private boolean accepted;
    private Date taskAccepted;

    private BigDecimal creditsEarned;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getLabId() {
        return labId;
    }

    public void setLabId(long labId) {
        this.labId = labId;
    }

    public Date getTaskGiven() {
        return taskGiven;
    }

    public void setTaskGiven(Date taskGiven) {
        this.taskGiven = taskGiven;
    }

    public Date getTaskFinished() {
        return taskFinished;
    }

    public void setTaskFinished(Date taskFinished) {
        this.taskFinished = taskFinished;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Date getTaskAccepted() {
        return taskAccepted;
    }

    public void setTaskAccepted(Date taskAccepted) {
        this.taskAccepted = taskAccepted;
    }

    public BigDecimal getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(BigDecimal creditsEarned) {
        this.creditsEarned = creditsEarned;
    }
}
