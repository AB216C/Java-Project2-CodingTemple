package StudentManagementSystem;
import java.util.ArrayList;
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
        if(grade<0){
            throw new IllegalArgumentException("Grade can not be negative. Try again");
        }else {
            this.grade = grade;
        }

    }
    public void setStudentId( int StudentId){
        this.StudentId = StudentId;
    }
    //Student methods
    public void addCourse(Course course){
        if(studentCourses.size()>4){
            throw new IllegalArgumentException("Student can not take more than 5 courses");

        }else {
            studentCourses.add(course);
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
