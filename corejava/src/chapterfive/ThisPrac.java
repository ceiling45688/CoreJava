package chapterfive;

/**
 * @author ceiling
 * @date 2019/2/5
 */
public class ThisPrac {
    /**
     * this关键字只能在方法内部使用，表示对“调用方法的那个对象”的引用
     * 如果在同一个类中调用另一个方法，可以不用写this之间调用即可。
     * this的两种用法：1.参数名与变量名重名；
     * 2.某构造方法的第一条语句为this(...)表示调用本类中其他构造方法
     */
    private String name;
    private int age;
    private double salary;
    public ThisPrac(){
        this("lily",21,1500);
    }
    public ThisPrac(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getSalary(){
        return salary;
    }
    public static void main(String[] args){
        ThisPrac a = new ThisPrac();
        System.out.println("name:" + a.getName());
        System.out.println("age:"+ a.getAge());
        System.out.println("salary:"+ a.getSalary());
    }
}
