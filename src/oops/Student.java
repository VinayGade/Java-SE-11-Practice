package oops;

public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // copy constructor
    public Student(Student s) {
        this.name=s.getName();
        this.age=s.getAge();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    Student(){}

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        Student s1=new Student("Vinay",30);
        Student s2=new Student();
        s2.setName("Ganesh");
        s2.setAge(29);
        Student s3=new Student(s2);

        System.out.println("student1 ="+s1.toString());
        System.out.println("student2 ="+s2.toString());
        System.out.println("student3 ="+s3.toString());
    }
}
