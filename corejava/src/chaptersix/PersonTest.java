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
//          toString()为重要的调试方法，建议每个类都加。
//          如果x为任意一个对象，且调用system.out.println(x); println()会直接调用x.toString()
            System.out.println("p.toString():"+ p);
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
    @Override  public String toString(){
//      最好通过getClass().getName()获得类名的字符串而不是直接写"xx类名".
        return getClass().getName()+ "[name= " + name + "]";
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
    @Override public String toString() {
        return super.toString()+ "[major= " + major + "]";
    }
}
