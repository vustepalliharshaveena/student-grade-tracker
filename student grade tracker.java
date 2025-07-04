import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeTracker 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        System.out.println("=== Student Grade Tracker ===");
        System.out.println("Enter records (name grade). Type \"done\" to finish.\n");
        while (true) 
        {
            System.out.print("Name (or done): ");
            String name = sc.next();
            if ("done".equalsIgnoreCase(name)) break;
            System.out.print("Grade (0‑100): ");
            double grade = sc.nextDouble();
            students.add(new Student(name, grade));
        }
        if (students.isEmpty()) 
        {
            System.out.println("\nNo data entered. Exiting.");
            return;
        }
        double total   = 0;
        double highest = -Double.MAX_VALUE;
        double lowest  =  Double.MAX_VALUE;
        for (Student s : students) 
        {
            double g = s.getGrade();
            total   += g;
            highest  = Math.max(highest, g);
            lowest   = Math.min(lowest,  g);
        }
        double average = total / students.size();
        System.out.println("\n----- Summary Report -----");
        System.out.printf("%-20s %6s%n", "Student", "Grade");
        System.out.println("------------------------------");
        for (Student s : students) {
            System.out.printf("%-20s %6.2f%n", s.getName(), s.getGrade());
        }
        System.out.println("------------------------------");
        System.out.printf("Average grade : %.2f%n", average);
        System.out.printf("Highest grade : %.2f%n", highest);
        System.out.printf("Lowest  grade : %.2f%n", lowest);
    }
}
