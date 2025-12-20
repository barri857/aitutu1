package Javaproject;
public class Course {

    private String courseName;
    private String instructor;
    private Student[] students;

    public Course(String courseName, String instructor, int arraySize) {
        this.courseName = courseName;
        this.instructor = instructor;

        this.students = new Student[arraySize];
    }

    public void addStudent(Student s, int index) {
        if (index >= 0 && index < students.length) {
            students[index] = s;
            System.out.println("-> " + s.getName() + " студенті " + courseName + " курсына қосылды.");
        } else {
            System.err.println("Қате   q1");
        }
    }

    public double courseAverageGPA() {
        if (students.length == 0) return 0.0;

        double totalGpa = 0.0;
        int studentCount = 0;

        for (Student s : students) {
            if (s != null) {
                totalGpa += s.getGpa();
                studentCount++;
            }
        }

        return studentCount > 0 ? totalGpa / studentCount : 0.0;
    }

    public Student highestCreditStudent() {
        Student maxCreditStudent = null;
        int maxCredits = -1;

        for (Student s : students) {
            if (s != null) {
                if (s.getCredits() > maxCredits) {
                    maxCredits = s.getCredits();
                    maxCreditStudent = s;
                }
            }
        }
        return maxCreditStudent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== Курс: ").append(courseName).append(" ===\n");
        sb.append("Оқытушы: ").append(instructor).append("\n");
        sb.append("Студенттер:\n");

        for (Student s : students) {
            if (s != null) {
                sb.append(s.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}