package StudentManagementSystem;

import java.util.ArrayList;

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
        if(subject==null||subject.trim().isEmpty()){
            throw new IllegalArgumentException("Subject can not be empty. Try again");
        }else{
            this.subject = subject;
        }

    }
    //Teacher's methods
    public void addCourse(Course course){
        if(teacherCourses.size()>2){
            throw new IllegalArgumentException("Teacher should not be assigned more than 3 courses");
        }else{
            teacherCourses.add(course);
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
