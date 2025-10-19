public class Student {
    private int id;
    private String name;
    private double gpa;
    private String city;
    private String college;

    public Student(int id, String name, double gpa, String city, String college) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.city = city;
        this.college = college;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public String getCity() { return city; }
    public String getCollege() { return college; }

    public void setName(String name) { this.name = name; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10.2f %-15s %-10s",
                id, name, gpa, city, college);
    }
}
