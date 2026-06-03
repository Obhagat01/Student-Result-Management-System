package model;

public class Result {
    private int rollNo;
    private String subject;
    private int marks;

    public Result(int rollNo, String subject, int marks) {
        this.rollNo = rollNo;
        this.subject = subject;
        this.marks = marks;
    }

    public int getRollNo() { return rollNo; }
    public String getSubject() { return subject; }
    public int getMarks() { return marks; }
}