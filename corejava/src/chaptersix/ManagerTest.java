package chaptersix;
import java.util.*;
/**
 * manager tesr
 *
 * @author  ceiling
 * @date 2019/3/14
 *
 * ps:同一个包中不能有两个同名类
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("bob",10000,1980,12,15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("lily",2000,1990,12,15);
        staff[2] = new Employee("jake",4000,1990,12,15);
        for (Employee e: staff){
            System.out.println("name = "+ e.getName() + ",salary = " + e.getSalary());
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, int year ,int month, int day){
        this.name = name;
        this.salary = salary;
        //java日历类calendar的子类 获取当前年月日
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }
    public String getName(){
        return  name;
    }
    public double getSalary(){
        return salary;
    }
    public Date getHireDay(){
        return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class Manager extends Employee {
    private  double bonus;
    public Manager(String name, double salary, int year, int month, int day){
        super(name,salary,year,month,day);
        bonus = 0;
    }

    @Override
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
}

