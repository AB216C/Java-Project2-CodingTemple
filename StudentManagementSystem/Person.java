package StudentManagementSystem;

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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty. Try again");
        }else{
            this.name = name;
        }
    }
    public void setAge(int age){
        if(age<0){
            throw new IllegalArgumentException("Age should be positive");
        }else{
            this.age = age;
        }
    }
    public void setEmail(String email){
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty. Try again");
        }else{
            this.email = name;
        }
    }
}
