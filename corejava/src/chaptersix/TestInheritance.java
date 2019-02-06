package chaptersix;

class Employee{
    private String name;
    private int age;
    private double salary;
    public Employee(){
        System.out.println("默认构造方法");
    }
    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }
}
class Manager extends Employee {
    private double bonus;
    public Manager(String name, int age, double salary, double bonus){
        super(name,age,salary);
        //调用父类有参构造方法，第一句，完成初始化.
        this.bonus = bonus;
    }
    public double getBonus(){
        return bonus;
    }
    @Override
    public double  getSalary(){
        return super.getSalary()+getBonus();
    }
}
public class TestInheritance {
    /**
     * @author ceiling
     * @date 2019/2/6
     *
     *
     * 注意：父类的属性和方法窦娥可以被子类继承，但子类不能继承父类的构造方法
     * 若在子类构造方法中调用父类构造方法，用super()(必须是第一句)
     * super也可用于调用父类的普通方法。
     */


    public static void main(String[] args){
        Employee employee = new Employee("lily",18,2000);
        System.out.println("Employee's salary: "+ employee.getSalary());
        Manager manager = new Manager("mary",30,5000,200);
        System.out.println("Manager's salary:"+manager.getSalary());
    }
}
