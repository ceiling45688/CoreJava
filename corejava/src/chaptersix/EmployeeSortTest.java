package chaptersix;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void  main(String[] args){
        Employee2[] staff = new Employee2[3];

        staff[0] = new Employee2("lily",2000);
        staff[1] = new Employee2("Nana",3000);
        staff[2] = new Employee2("Rose",4000);

        Arrays.sort(staff);

        for (Employee2 e : staff){
            System.out.println("name = " + e.getName()+ "salary =" +e.getSalary());
        }
    }

}
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
