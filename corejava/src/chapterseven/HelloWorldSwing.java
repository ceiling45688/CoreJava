package chapterseven;

import javax.swing.*;
import java.awt.*;

/**
 * @author ceiling
 * @date 2019/3/26
 * tips: 绘制简单组件
 */
public class HelloWorldSwing {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloWorldFrame frame = new HelloWorldFrame();
//                关闭frame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                显示
                frame.setVisible(true);
            }
        });
    }
}
class HelloWorldFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULET_HEIGHT = 400;

    public HelloWorldFrame() {
        setTitle("HelloWorld");
        setSize(DEFAULT_WIDTH, DEFAULET_HEIGHT);
//       添加绘画至框架
        HelloWorldComponent component = new HelloWorldComponent();
        add(component);
//        HelloWorldPanel panel = new HelloWorldPanel();
//        add(panel);
    }
}
class HelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
//  绘制组件
    @Override public void paintComponent(Graphics g){
        g.drawString("I'm ceiling.", MESSAGE_X, MESSAGE_Y);
    }
}
/**
 * 也可以用JPanel扩展，代码如下
 */
//class HelloWorldPanel extends JPanel{
//    public static final int MESSAGE_X = 75;
//    public static final int MESSAGE_Y = 100;
//
//    @Override public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawString("I'm ceiling.", MESSAGE_X, MESSAGE_Y);
////    }
//}
