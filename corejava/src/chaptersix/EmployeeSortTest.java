package chaptersix;

import java.util.Arrays;

/**
 * @author ceiling
 * @date 2019/3/20
 */
public class EmployeeSortTest {
    public static void  main(String[] args){
        Employee2[] staff = new Employee2[3];

        staff[0] = new Employee2("lily",2000);
        staff[1] = new Employee2("Nana",3000);
        staff[2] = new Employee2("Rose",4000);
        /**
         * 使用array.sort()排序，主类必须实现Comparable接口
         */
        Arrays.sort(staff);

        for (Employee2 e : staff){
            System.out.println("name = " + e.getName()+ "salary =" +e.getSalary());
        }
    }

}

/**
 * 实现接口步骤：1）将类声明为实现给定的接口 2）对接口中的所有方法进行定义
 *
 * int compareTo<T other> 用这个对象与other进行比较，如果小于other返回负值，相等返回0，大于返回正值
 */
class Employee2 implements Comparable<Employee2>{
    private String name;
    private double salary;
    public Employee2 (String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }

    @Override public int compareTo(Employee2 other){
        if (salary < other.salary){ return  -1;}
        if (salary > other.salary){ return  1;}
        return 0;
    }
}
