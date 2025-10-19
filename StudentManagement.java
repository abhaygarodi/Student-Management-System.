import java.util.*;

public class StudentManagement {
    private static final List<Student> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Default Students");
            System.out.println("2. Display All Students");
            System.out.println("3. Add New Student");
            System.out.println("4. Search by City");
            System.out.println("5. Update GPA");
            System.out.println("6. Sort by Name");
            System.out.println("7. Sort by GPA");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addDefaultStudents();
                case 2 -> displayStudents(students);
                case 3 -> addStudent();
                case 4 -> searchByCity();
                case 5 -> updateGpa();
                case 6 -> sortByName();
                case 7 -> sortByGpa();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void addDefaultStudents() {
        students.add(new Student(1, "Abhay", 8.7, "Pune", "MIT"));
        students.add(new Student(2, "Riya", 9.1, "Mumbai", "SPIT"));
        students.add(new Student(3, "Karan", 7.8, "Nagpur", "VIT"));
        students.add(new Student(4, "Priya", 8.5, "Pune", "MIT"));
        System.out.println("✅ Default students added successfully!");
    }

    private static void displayStudents(List<Student> students) {
        System.out.println("\nID    Name            GPA        City            College");
        System.out.println("--------------------------------------------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();

        students.add(new Student(id, name, gpa, city, "MIT"));
        System.out.println("✅ Student added successfully!");
    }

    private static void searchByCity() {
        System.out.print("Enter city to search: ");
        String city = sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.getCity().equalsIgnoreCase(city)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found)
            System.out.println("❌ No students found in this city.");
    }

    private static void updateGpa() {
        System.out.print("Enter student ID to update GPA: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new GPA: ");
                double newGpa = sc.nextDouble();
                s.setGpa(newGpa);
                System.out.println("✅ GPA updated successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    private static void sortByName() {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparing(Student::getName));
        System.out.println("✅ Students sorted by Name:");
        displayStudents(sorted);
    }

    private static void sortByGpa() {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        System.out.println("✅ Students sorted by GPA:");
        displayStudents(sorted);
    }
}
