package chaptersix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

/**
 * @author ceiling
 * @date 2019/3/22
 * tips: 内部类语法比较复杂，且涉及到编译器内部机制啥的。。
 * 了解到内部类拥有访问特权就可了，与常规类相比起来功能更强大。
 */
public class InnerClassTest {
    public static void main(String[] args){
        TalkingClock clock = new TalkingClock(10000,true);
        clock.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        TimePrinter2 listener = new TimePrinter2();
        Timer t = new Timer(interval,listener);
        t.start();
    }

    /**
     *     InnerClass
     *     如果把内部类声明为私有的，则只有TalkClock的方法才能生成TimePrint2对象
     *     如果声明为公有的，则具有包可见性，或公有可见性。
     *
     *     ps：本例中TimePrinter2类名只在star()方法中使用了一次，
     *     所以也可以在start(){ }中创建局部内部类，
     *     注意声明时不能带public/private等访问说明符，作用域只限于这个块中。
     *     好处是，除start外，对外部完全隐藏。
     *
     *     pps：本例中start(){ }中也可以使用匿名内部类。
     */

    private class TimePrinter2 implements ActionListener{
        @Override public void actionPerformed(ActionEvent event){
            Date now = new Date();
            System.out.println("At the tone , the time is " + now);
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
