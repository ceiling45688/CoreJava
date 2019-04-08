package chaptereight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author ceiling
 * @date 2019/4/7
 * tips:动作响应按钮、菜单项、点击键盘注意点：
 * 1）实现一个扩展AbstractAction类的类，多个相关的动作可以使用一个类。
 * 2）击键触发需要得到顶层组件的WHEN_ANCESTOR_OF_FOCUS_COMPONENT输入映射，再将击键的KeyStroke.getKeyStroke（）,即（击键，动作键描述字符串）添加到输入映射中
 * 得到顶层组件的动作映射，将（动作键描述字符串，动作对象）添加到动作映射中（这里使用ActionMap）
 */
public class ActionTest {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ActionFrame frame = new ActionFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

class ActionFrame extends JFrame {
    private JPanel buttonPanel;
    public ActionFrame() {
        setTitle("ActionTest");
        setSize(300,200);
        buttonPanel = new JPanel();
//       定义动作
        Action yellowAction = new ColorAction("YELLOW",new ImageIcon(),Color.YELLOW);
        Action blueAction = new ColorAction("BLUE",new ImageIcon(),Color.BLUE);
        Action greenAction = new ColorAction("GREEN",new ImageIcon(),Color.GREEN);
//      add buttons for actions
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(greenAction));

        add(buttonPanel);
//      动作与键盘关联
//        InputMap 是映射keystroke对象到任一对象上，然后需要用actionmap类将对象映射到动作上
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl G"),"panel.green");
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow",yellowAction);
        amap.put("panel.blue",blueAction);
        amap.put("panel.green",greenAction);

    }

    public class ColorAction extends AbstractAction {
        public ColorAction (String name , Icon icon, Color color){
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "set panel color to "+name.toLowerCase());
            putValue("color",color);
        }

       @Override public void actionPerformed(ActionEvent event){
            Color c = (Color)getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}