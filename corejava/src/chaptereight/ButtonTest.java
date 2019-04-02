package chaptereight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ceiling
 * @date 2019/4/1
 * tips: 简单的事件监听
 */
public class ButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonFrame frame = new ButtonFrame();
//                关闭frame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                显示
                frame.setVisible(true);
            }
        });
    }
}
class ButtonFrame extends JFrame {
    public static final int  DEFAULT_WIDTH = 600;
    public static final int  DEFAULT_HEIGHT = 400;
    private JPanel buttonPanel;

    public ButtonFrame() {
        setTitle("ButtonTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//       添加按钮至面板上
        JButton yellowButton = new JButton("yellow");
        JButton blueButton = new JButton("blue");
        JButton redButton = new JButton("red");

        buttonPanel = new JPanel();
//        添加panel到frame
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);
//      创建颜色对象（事件源）
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);
//        添加按钮监听器（注册监听器）
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
/**
 *      上面代码因为重复较多，可以简化，
 *
 *      public void makeButton(String name, final Color backgroundColor){
 *          JButton button = new JButton(name);
 *          buttonPanel.add(button);
 *
 *          ColorAction action = new ColorAction(backgroundColor);
 *          button.addActionListener(action);
 *      }
 *      下面使用的监听器因为内容简单也可以简化为匿名内部类。(这样更好)
 *       public void makeButton(String name, final Color backgroundColor){
 *           JButton button = new JButton(name);
 *           buttonPanel.add(button);
 *           button.addActionListener(new ActionListener()
 *           {
 *              public void actionPerformed(ActionEvent event){
 *                  buttonPanel.setBackground(backgroundColor);
 *              }
 *           });
 *       }
 *
 */
    }
//        为了让ColorAction可以访问buttonPanel，这里使用内部类；
//        监听器必须实现ActionListener接口，且应包含actionPerformed方法

        class ColorAction implements ActionListener {
            private Color backgroundColor;

//            设置面板背景为指定颜色

            public ColorAction(Color c) {
                backgroundColor = c;
            }
            @Override public void actionPerformed(ActionEvent event) {
                buttonPanel.setBackground(backgroundColor);
            }
        }

}
