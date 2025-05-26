package StudentManagementSystem;
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
        if(courseName==null||courseName.trim().isEmpty()){
            throw new IllegalArgumentException("Course name can not be empty. Try again");
        }else{
            this.courseName = courseName;
        }

    }
    //Representing created objects in a string format
    @Override
    public String toString() {
        return courseId + ":" + courseName;
    }
}