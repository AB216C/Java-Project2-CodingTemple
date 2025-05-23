package StudentManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

//Super class
class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age,String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //Getter methods
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEmail() {
        return email;
    }

    //Setter methods
    public void setName(String name){
        if(name==null|| name.isEmpty()){
            throw new IllegalArgumentException("Name should not be blank. Please Enter a name");
        } else{
            this.name = name;
        }
    }
    public void setAge(int age){
        if(age<0){
            throw new IllegalArgumentException("Age must be positive");
        }else{
            this.age = age;
        }
    }
    public void setEmail(String email){
        if(email==null||email.isEmpty()){
            throw new IllegalArgumentException("Email should not be empty. Please enter the email");
        }else{
            this.email = email;
        }
    }
}
//Student class-subclass
class Student extends Person {
    private int StudentId;
    private int grade;
    private ArrayList<Course> studentCourses  = new ArrayList<>();;

    public Student(int StudentId, int grade, String name, int age, String email) {
        super(name,age,email);
        this.grade = grade;
        this.StudentId = StudentId;
    }

    //Student Getters
    public int getGrade(){
        return grade;
    }
    public int getStudentId(){
        return StudentId;
    }

    //Setters
    public void setGrade(int grade){
        this.grade = grade;
    }
    public void setStudentId( int StudentId){
        this.StudentId = StudentId;
    }

    //Student methods
    public void addCourse(Course course){
        if(studentCourses.size()<5){
            studentCourses.add(course);
        }else {
            System.out.println("Student can not take more than 5 courses");
        }
    }
    public ArrayList<Course> getCourse(){
        return studentCourses;
    }
    //Representing created objects in a string format
    @Override
    public String toString(){
        return "StudentID:" + getStudentId() + ", Name:" + getName() + ", Age:" + getAge() + ", Email:" + getEmail() + ", Grade:" + getGrade();
    }
}
//Teacher class-subclass
class Teacher extends Person{
    private int teacherId;
    private String subject;

    private ArrayList<Course> teacherCourses= new ArrayList<>();;

    public Teacher(int teacherId, String subject, String name, int age, String email){
        super(name,age,email);
        this.teacherId = teacherId;
        this.subject = subject;
    }

    //Teacher's Getters
    public int getTeacherId(){
        return teacherId;
    }
    public String getSubject(){
        return subject;
    }

    //Teacher's Setters
    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }

    //Teacher's methods
    public void addCourse(Course course){
        if(teacherCourses.size()<3){
            teacherCourses.add(course);
        }else{
            throw new IllegalArgumentException("Teacher should teach no more than 3 courses.");
        }
    }

    public ArrayList<Course> getCourse(){
        return teacherCourses;
    }
    //Representing created objects in a string format
    @Override
    public String toString(){
        return "TeacherID:" + teacherId + ", Name:" + getName() + ", Age:" + getAge() + ", Email:" + getEmail() + ", Subject:" + getSubject();
    }
}

//Course class-subclass
class Course {
    private String courseName;
    private int courseId;

    public Course (String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    //Course's Getters
    public int getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }

    //Course's Setters
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
   //Representing created objects in a string format
    @Override
    public String toString() {
        return courseId + ":" + courseName;
    }
}

public class StudentManagementSystemManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    static int studentIdCounter = 100;
    static int teacherIdCounter = 200;
    static int courseIdCounter = 300;

    private static void displayMenu() {
        System.out.println("\n =====Student Management System====");
        System.out.println("1. Add  Student");
        System.out.println("2. Add  Teacher");
        System.out.println("3. Add Course");
        System.out.println("4. Assign Course to Student");
        System.out.println("5. Assign Course to Teacher");
        System.out.println("6. View Student by Id");
        System.out.println("7. View Teacher by ID");
        System.out.println("8. View AllStudentsAndTeachers");
        System.out.println("9. ViewAllCourses");
        System.out.println("10. Update Student");
        System.out.println("11. Update Teacher");
        System.out.println("12. Delete Student");
        System.out.println("13. Delete Teacher");
        System.out.println("14. Exit");
        System.out.println("Enter your option: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            displayMenu();
            int option = input.nextInt();
            input.nextLine();

            switch(option) {
                case 1: addStudent(input);
                break;
                case 2 : addTeacher(input);
                break;
                case 3 : addCourse(input);
                break;
                case 4 : assignCourseToStudent(input);
                break;
                case 5 : assignCourseToTeacher(input);
                break;
                case 6 : viewStudentById(input);
                break;
                case 7: viewTeacherById(input);
                break;
                case 8: viewAllStudentsAndTeachers();
                break;
                case 9: viewAllCourses();
                break;
                case 10: updateStudent(input);
                break;
                case 11: updateTeacher(input);
                break;
                case 12 : deleteStudent(input);
                break;
                case 13: deleteTeacher(input);
                break;
                case 14 :
                    System.out.println("Program Exiting now........");
                    return;
                default: System.out.println("This option is not available. Please try 1 to 11");

            }
        }
    }

    private static void addStudent(Scanner input) {
        try {
            System.out.println("Enter Student's name: ");
            String name = input.nextLine();
            System.out.println("Enter Student's age: ");
            int age = input.nextInt();
            input.nextLine();
            System.out.println("Enter student's email: ");
            String email = input.nextLine();
            System.out.println("Enter Student's grade");
            int grade = input.nextInt();

            int studentId = studentIdCounter++;
            Student student = new Student(studentId, grade,name, age, email);
            students.add(student);
            System.out.println("Student with ID: " + studentId + " has been added successfully");

        } catch(Exception e) {
            System.out.println("Invalid Input" + e.getMessage());
        }
    }

    private static void addTeacher(Scanner input) {
        try{
            System.out.println("Enter Teacher's name: ");
            String name = input.nextLine();
            System.out.println("Enter Teacher's age: ");
            int age = input.nextInt();
            input.nextLine();
            System.out.println("Enter Teacher's email: ");
            String email = input.nextLine();
            System.out.println("Enter Teacher's subject: ");
            String subject = input.nextLine();

            int teacherId = teacherIdCounter++;
            Teacher teacher = new Teacher(teacherId, subject,name, age, email);
            teachers.add(teacher);
            System.out.println("Teacher with ID: " + teacherId + " has been added successfully");

        } catch(Exception e) {
            System.out.println("Invalid Input" + e.getMessage());
        }
    }

    private static void addCourse(Scanner input) {
        System.out.println("Enter the course name: ");
        String courseName = input.nextLine();
        int courseId = courseIdCounter++;
        Course course = new Course(courseName,courseId);
        courses.add(course);
        System.out.println("Course with ID: " + courseId + " has been added successfully");
    }

    private static void assignCourseToStudent(Scanner input) {
        System.out.println("Enter Student ID:");
        int id = input.nextInt();
        input.nextLine();
        Student student = students.stream().filter(s->s.getStudentId()==id).findFirst().orElse(null);
        if(student==null){
            System.out.println("Student not found");
            return;
        }

        listCourses();
        System.out.println("Enter course id you want to assign: ");
        int courseId = input.nextInt();
        input.nextLine();

        Course course = courses.stream().filter(c->c.getCourseId()==courseId).findFirst().orElse(null);
        if(course !=null) {
            student.addCourse(course);
            System.out.println("Course with id:" + id + " has been assigned to " + student.getName());
        } else{
            System.out.println("Course not found");
        }

    }

    private static void assignCourseToTeacher(Scanner input) {
        System.out.println("Enter Teacher ID:");
        int id = input.nextInt();
        input.nextLine();
        Teacher teacher = teachers.stream().filter(t->t.getTeacherId()==id).findFirst().orElse(null);
        if(teacher==null){
            System.out.println("Teacher not found");
            return;
        }

        listCourses();
        System.out.println("Enter course id you want to assign: ");
        int courseId = input.nextInt();
        input.nextLine();

        Course course = courses.stream().filter(c->c.getCourseId()==courseId).findFirst().orElse(null);
        if(course !=null) {
            teacher.addCourse(course);
            System.out.println("Course with id:" + id + " has been assigned to " + teacher.getName());
        } else{
            System.out.println("Course not found");
        }
    }


    private static void viewStudentById(Scanner input) {
        System.out.println("Enter Student ID:");
        int id = input.nextInt();
        input.nextLine();

        Student student = students.stream().filter(s->s.getStudentId()==id).findFirst().orElse(null);
        if(student!=null){
            System.out.println(student);
            System.out.println("Courses: "+ student.getCourse());
        } else {
            System.out.println("Student not found");
        }
    }

    private static void viewTeacherById(Scanner input) {
        System.out.println("Enter Teacher ID:");
        int id = input.nextInt();
        input.nextLine();

        Teacher teacher = teachers.stream().filter(t->t.getTeacherId()==id).findFirst().orElse(null);
        if(teacher!=null){
            System.out.println(teacher);
            System.out.println("Courses: "+ teacher.getCourse());
        } else {
            System.out.println("Teacher not found");
        }
    }

    private static void viewAllStudentsAndTeachers(){
        System.out.println("\nStudents: ");
        students.forEach(System.out::println);
        System.out.println("\nTeachers: ");
        teachers.forEach(System.out::println);
    }

    private static void viewAllCourses (){
        System.out.println("\nCourses: ");
        courses.forEach(System.out::println);
    }

    private static void updateStudent (Scanner input) {
        System.out.println("Enter student Id: ");
        int id = input.nextInt();
        input.nextLine();

        Student student = students.stream().filter(s->s.getStudentId()==id).findFirst().orElse(null);
        if(student==null){
            System.out.println("Student not found");
            return;
        }

        try {
            System.out.println("Update name: ");
            student.setName(input.nextLine());

            System.out.println("Update age: ");
            student.setAge(input.nextInt());
            input.nextLine();

            System.out.println("Update email: ");
            student.setEmail(input.nextLine());

            System.out.println("Update  grade: ");
            student.setGrade(input.nextInt());
            System.out.println("Student has been updated");
        }catch(Exception e) {
            System.out.println("Error updating student" + e.getMessage());
        }
    }

    private static void updateTeacher (Scanner input) {
        System.out.println("Enter teacher Id: ");
        int id = input.nextInt();
        input.nextLine();

        Teacher teacher = teachers.stream().filter(s->s.getTeacherId()==id).findFirst().orElse(null);
        if(teacher==null){
            System.out.println("teacher not found");
            return;
        }

        try {
            System.out.println("Update name: ");
            teacher.setName(input.nextLine());

            System.out.println("Update age: ");
            teacher.setAge(input.nextInt());
            input.nextLine();

            System.out.println("Update email: ");
            teacher.setEmail(input.nextLine());

            System.out.println("Update  Subject: ");
            teacher.setSubject(input.nextLine());
            System.out.println("Teacher has been updated");
        }catch(Exception e) {
            System.out.println("Error updating teacher" + e.getMessage());
        }
    }

    private static void deleteStudent(Scanner input){
        System.out.println("Enter id of student to delete");
        int id = input.nextInt();
        input.nextLine();

        boolean removed = students.removeIf(s->s.getStudentId()==id);

        if(removed) {
            System.out.println("Student with id:" + id + " has been deleted");
        }else{
            System.out.println("Student not found");
        }
    }

    private static void deleteTeacher(Scanner input){
        System.out.println("Enter id of a teacher to delete");
        int id = input.nextInt();
        input.nextLine();

        boolean removed = teachers.removeIf(t->t.getTeacherId()==id);

        if(removed) {
            System.out.println("Teacher with id:"+id + " has been deleted");
        }else{
            System.out.println("Teacher not found");
        }
    }

    private static void listCourses (){
        System.out.println("List of all courses available: ");
        courses.forEach(System.out::println);
    }

}
