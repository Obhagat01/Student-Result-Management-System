javapackage model;

public class Student {private int rollNo;private String name;private String branch;private int semester;

// Constructor
public Student(int rollNo, String name, String branch, int semester) {
    this.rollNo = rollNo;
    this.name = name;
    this.branch = branch;
    this.semester = semester;
}

// Getters & Setters
public int getRollNo() { return rollNo; }
public String getName() { return name; }
public String getBranch() { return branch; }
public int getSemester() { return semester; }
public void setName(String name) { this.name = name; }

}