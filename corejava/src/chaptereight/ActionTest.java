package chaptereight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author ceiling
 * @date 2019/4/7
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