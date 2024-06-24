package assignment5;
import java.util.*;
public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
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

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean canEnroll() {
        return enrolledStudents < capacity;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void dropStudent() {
        enrolledStudents--;
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
        if (course.canEnroll()) {
            registeredCourses.add(course);
            course.enrollStudent();
            System.out.println(name + " has registered for course: " + course.getCourseCode());
        } else {
            System.out.println("Course " + course.getCourseCode() + " is full. Registration failed.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.dropStudent();
            System.out.println(name + " has dropped course: " + course.getCourseCode());
        } else {
            System.out.println(name + " is not registered in course: " + course.getCourseCode());
        }
    }
}
 class CourseListing {
    private List<Course> courses;

    public CourseListing() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Enrolled Students: " + course.getEnrolledStudents());
            System.out.println("-----------------------------");
        }
    }
}
class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Create courses
        Course c1 = new Course("CS101", "Introduction to Java", "Basic Java programming", 30, "Mon/Wed 10:00 AM");
        Course c2 = new Course("CS202", "Data Structures", "Advanced data structures", 25, "Tue/Thu 1:00 PM");

        // Create course listing
        CourseListing courseListing = new CourseListing();
        courseListing.addCourse(c1);
        courseListing.addCourse(c2);

        // Create students
        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");

        // Display available courses
        courseListing.displayCourses();

        // Alice registers for courses
        s1.registerCourse(c1);
        s1.registerCourse(c2);

        // Bob registers for a course
        s2.registerCourse(c1);

        // Display updated course details
        courseListing.displayCourses();

        // Alice drops a course
        s1.dropCourse(c2);

        // Display updated course details
        courseListing.displayCourses();
    }
}
