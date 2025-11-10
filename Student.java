public class Student {
    private int rollNumber;
    private String studentName;
    private int[] marks = new int[3];

    public Student(int rollNumber, String studentName, int[] marks) throws InvalidMarksException {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
        validateMarks();
    }

    // Validate marks in range 0-100
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i+1) + ": " + marks[i]);
            }
        }
    }

    public double calculateAverage() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total / 3.0;
    }

    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println("\nAverage: " + calculateAverage());

        if (calculateAverage() >= 40) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
