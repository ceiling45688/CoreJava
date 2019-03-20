package chaptersix;
import java.util.*;

/**
 * @author ceiling
 * @date 2019/3/20
 *
 * tip: java clone机制
 * 1）clone的目的是得到一个完全一致的对象，不同于copy，clone后改变对象不影响原始对象状态（内存地址不同）
 * 2）深拷贝和浅拷贝：
 * 浅拷贝（默认）---能复制变量，如果对象内还有对象，则只能复制对象的地址（改变会影响原对象）
 * 深拷贝---能复制变量，也能复制当前对象的 内部对象
 * 实现深拷贝必须clone所有可变的实例域（包括内部对象）
 *
 * 3)clone需要实现Cloneable接口,且要声明CloneNotSupportedException 异常
 */


public class CloneTest {
    public static void main(String[] args){
        try{
            Employee3 original = new Employee3("lily",2000);
            original.setHireDay(2010,3,10);
            Employee3 clone = original.clone();
            clone.setHireDay(2012,3,10);
            System.out.println("original = " + original);
            System.out.println("clone = "+ clone);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

}
class Employee3 implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee3(String name, double salary){
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }
    public void  setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    /**
     *深拷贝需要把内部对象也clone
     */
    @Override  public Employee3 clone() throws CloneNotSupportedException{
       // 调用Object.clone() 克隆基本类型
        Employee3 cloned = (Employee3) super.clone();
        //clone内部对象Date
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    @Override  public String toString(){
        return "Employee[name = " + name + ",salary = "+ salary +",hireDay = " + hireDay + "]";
    }
}