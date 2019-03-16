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

class Employee extends Person{
    private double salary;
    private Date hireDay;

    public Employee(String name ,double salary, int year ,int month, int day){
        super(name);
        this.salary = salary;
        //java日历类calendar的子类 获取当前年月日
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }
    @Override
    /**
     * 定义超类中所有抽象方法，这是是getDescription().输出格式化字符串
     * ps:ToString()是将其他数据类型转换为String并格式化，format()则是对String格式化。
     * pps: 常用转换符： $s -> "string" , %c -> 'c', %b -> true, %d, %x %o %f
     * +     为正数或者负数添加符号(“%+d”,15)        +15
     * 0     数字前面补0(加密常用) (“%04d”, 99)      0099
     * 空格  在整数之前添加指定数量的空格(“% 4d”, 99)  99
     * ,     以“,”对数字分组(常用显示金额) (“%,f”, 9999.99) 9,999.990000
     * (     使用括号包含负数   (“%(f”, -99.99)       (99.990000)
     * #     如果是浮点数则包含小数点，如果是16进制或8进制则添加0x或0(“%#x”, 99)(“%#o”, 99)  0x63 0143
     * <     格式化前一个转换符所描述的参数   (“%f和%<3.2f”, 99.45)    99.450000和99.45
     */
    public String getDescription(){
        return String.format("an Employee with a salary of %.2f", salary);
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

