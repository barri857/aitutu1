package Javaproject;

public class Main {
    public static Student getTopStudent(Student[] arr) {
        if (arr == null || arr.length == 0) return null;
        Student top = arr[0];
        for (Student s : arr) {
            if (s != null && s.getGpa() > top.getGpa()) {
                top = s;
            }
        }
        return top;
    }

    public static int countHonors(Student[] arr) {
        int count = 0;
        for (Student s : arr) {
            if (s != null && s.isHonors()) {
                count++;
            }
        }
        return count;
    }

    public static int totalCredits(Student[] arr) {
        int total = 0;
        for (Student s : arr) {
            if (s != null) {
                total += s.getCredits();
            }
        }
        return total;
    }

    public static void main(String[] args) {

        Student[] studentArray = new Student[5];

        // 2. Студент объектілерін жасау (Instantiate multiple Student objects)
        studentArray[0] = new Student("Aizhan", "S101", "Management");
        studentArray[1] = new Student("Bakhytzhan", "S102", "IT");
        studentArray[2] = new Student("Dinara", "S103", "Finance");
        studentArray[3] = new Student("Erlan", "S104", "IT");
        studentArray[4] = new Student("Gulmira", "S105", "Management");

        // 3. GPA және кредиттерді модификациялау
        studentArray[0].addCredits(30); studentArray[0].updateGPA(3.9);
        studentArray[1].addCredits(45); studentArray[1].updateGPA(3.2);
        studentArray[2].addCredits(30); studentArray[2].updateGPA(3.6);
        studentArray[3].addCredits(60); studentArray[3].updateGPA(2.8);
        studentArray[4].addCredits(15); studentArray[4].updateGPA(4.0);

        // 4. Деректерді өңдеу (Part 2 - Arrays & Calculations) [cite: 70]
        System.out.println("====== Student Array Processing ======");

        Student topStudent = getTopStudent(studentArray); // [cite: 76]
        int honorsCount = countHonors(studentArray);      // [cite: 76]
        int totalCrd = totalCredits(studentArray);        // [cite: 77]

        // Нәтижелерді шығару [cite: 68]
        System.out.println("Highest GPA Student: " + (topStudent != null ? topStudent.getName() : "N/A"));
        System.out.println("Number of Honors Students: " + honorsCount);
        System.out.println("Total Credits Earned: " + totalCrd);

        // 5. Course объектісін құру және Composition-ды көрсету
        System.out.println("\n====== Course Interaction ======");
        Course javaCourse = new Course("Java OOP", "Mr. Omar", 5);

        // Студенттерді курсқа қосу (addStudent) [cite: 41, 69]
        javaCourse.addStudent(studentArray[0], 0);
        javaCourse.addStudent(studentArray[1], 1);
        javaCourse.addStudent(studentArray[4], 2);

        // 6. toString() арқылы толық ақпаратты шығару [cite: 65, 68]
        System.out.println(javaCourse.toString());

        // Ең жоғары кредиті бар студентті курс ішінен табу [cite: 45]
        Student maxCrdStudent = javaCourse.highestCreditStudent();
        if (maxCrdStudent != null) {
            System.out.println("Course Max Credit Student: " + maxCrdStudent.getName());
        }
    }
}