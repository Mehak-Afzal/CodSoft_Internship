import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void registerStudent(Student student) {
        registeredStudents.add(student);
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description
                + "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Course addedd successfully");
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        System.out.println("Course dropped successfully");
    }

    public boolean isRegisteredForCourse(Course course) {
        return registeredCourses.contains(course);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name;
    }
}

class CourseDatabase {
    private List<Course> courses;
    private List<Student> studentDatabase;

    public CourseDatabase() {
        courses = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        studentDatabase.add(student);
    }

    public List<Student> getStudentDatabase() {
        return studentDatabase;
    }

    public List<Course> getCourseDatabase() {
        return courses;
    }

    public void listCourses() {
        for (Course course : courses) {
            System.out.println(course);
            int availableSlots = course.getCapacity() -
                    countStudentsRegisteredForCourse(course);
            System.out.println("Available Slots: " + availableSlots + "\n");
        }
    }

    public int countStudentsRegisteredForCourse(Course course) {
        int count = 0;
        for (Student student : course.getRegisteredStudents()) {
            if (student.isRegisteredForCourse(course)) {
                count++;
            }
        }
        return count;
    }
}

public class Task4 {
    public static void main(String[] args) {
        CourseDatabase registrationSystem = new CourseDatabase();

        // Adding courses to the system
        Course course1 = new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 50,
                "Mon/Wed/Fri 10:00 AM");
        Course course2 = new Course("MATH201", "Calculus I", "Limits, derivatives, and integrals", 40,
                "Tue/Thu 2:00 PM");
        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);

        // Adding students to the system
        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Sarah Jane");
        registrationSystem.addStudent(student1);
        registrationSystem.addStudent(student2);

        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        // Course registration simulation
        while (true) {
            System.out.println("Welcome to Student course registraton System");
            System.out.println("1. Display Course Listing");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registrationSystem.listCourses();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = input.nextInt();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.next();

                    Student student = null;
                    Course course = null;

                    for (Student s : registrationSystem.getStudentDatabase()) {
                        if (s.getStudentID() == studentId) {
                            student = s;
                            break;
                        }
                    }

                    for (Course c : registrationSystem.getCourseDatabase()) {
                        if (c.getCourseCode().equals(courseCode)) {
                            course = c;
                            break;
                        }
                    }

                    if (student != null && course != null) {
                        student.registerCourse(course);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    String studentIdDrop = scanner.next();
                    System.out.print("Enter course code: ");
                    String courseCodeDrop = scanner.next();

                    Student studentDrop = null;
                    Course courseDrop = null;

                    for (Student s : registrationSystem.getStudentDatabase()) {
                        int idd = Integer.parseInt(studentIdDrop);
                        if (s.getStudentID() == idd) {
                            studentDrop = s;
                            break;
                        }
                    }

                    for (Course c : registrationSystem.getCourseDatabase()) {
                        if (c.getCourseCode().equals(courseCodeDrop)) {
                            courseDrop = c;
                            break;
                        }
                    }

                    if (studentDrop != null && courseDrop != null) {
                        studentDrop.dropCourse(courseDrop);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
