package chaptersix;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * @author ceiling
 * @date 2019/3/22
 * tips：定时器，需要实现java.awt.event包的ActionListener接口，到达指定时间调用actionPerformed方法。
 */
public class TimerTest {
    public static void main(String[] args){
        TimePrinter listener = new TimePrinter();
//      import javax.swing.Timer  Timer构造器（时间间隔，监听器对象）
        Timer t = new Timer(10000, listener);
        t.start();
//      Swing 中弹出带有ok的对话框
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
class TimePrinter implements ActionListener {
    @Override public void actionPerformed(ActionEvent event){
        Date now = new Date();
        System.out.println("At the tone , the time is " + now);
        /**
         *  Toolkit是一个控件，工具箱包含有关GUI环境的信息
         *  为抽象类无法实例化，用getDefaultToolkit()返回Toolkit类的对象
         *  这里使用beep()方法返回 “beep”声音
         */
        Toolkit.getDefaultToolkit().beep();
    }
}
