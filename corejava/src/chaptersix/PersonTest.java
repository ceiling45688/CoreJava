package chaptersix;


/**
 * @author ceiling
 * @date 2019/3/16
 */

public class PersonTest {
    public static void main(String[] args){
        Person[] people = new Person[2];
        people[0] = new Employee("lily",2000,1997,3,20);
        people[1] = new Student("Tony","cs");
        /**
         * 由于不能构造抽象类Person的对象
         * 下面的p.getDescription()是引用的其具体子类对象重载后的方法。
         */
        for (Person p : people){
            System.out.println(p.getName()+ ","+p.getDescription());
        }
    }
}

abstract class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }
    public abstract String getDescription();

    public String getName(){
        return name;
    }
}

class Student extends Person {
    private String major;
    public Student(String name, String major){
        super(name);
        this.major = major;
    }
    @Override public String getDescription(){
        return String.format("a student majoring in %s", major);
    }
}
