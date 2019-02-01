package ChapterThree;
import java.util.*;
/**
*
*@author celing
*@date 2019/2/1
*/
public class SwitchTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        switch (number){
            case 1:
                System.out.println("第一名");
                break;
            case 2:
                System.out.println("第二名");
                break;
            case 3:
                System.out.println("第三名");
                break;
            default:
                System.out.println("出局");
        }
    }
}
