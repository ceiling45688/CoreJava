package chaptersix;
import java.util.*;

public class EunmTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size : (SMALL,MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.nextLine();
        //返回指定名字，给定类的枚举常量
        Size size = (Size) Enum.valueOf(Size.class, input);
        System.out.println("size = " + size);
        System.out.println("abbreviation = " + size.getAbbr());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("good job -- you pai attention to the _.");
        }
    }
}
enum Size {
    /**
     * 枚举类型包括有限个命名的值（可加参数），
     * 其变量只能存储这个类型声明中给定的某个枚举值或者null值
     * 使用方式：类名.枚举值
     * 常用方法：1：类名.枚举值.toString() 返回枚举常量名
     * 2： Enum.valueOf(Class enumClass, String name) 返回指定名字、给定类的枚举常量
     */
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbr;

    private Size(String abbr){
        this.abbr = abbr;
    }
    public String getAbbr(){
        return abbr;
    }
}