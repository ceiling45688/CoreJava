package chaptereight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ceiling
 * @date 2019/4/8
 * tips: change the LookAndFeel
 */
public class PlafTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PlafFrame frame = new PlafFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class PlafFrame extends JFrame {
    private JPanel buttonPanel;
    public PlafFrame(){
        setTitle("PlafFrame");
        setSize(600, 400);
        buttonPanel = new JPanel();

//        get all of lookandfeel
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos){
            makeButton (info.getName(), info.getClassName());
        }
//        add panel
        add(buttonPanel);
    }

    void makeButton(String name, final String classname){
//        add button to the panel
        JButton button = new JButton(name);
        buttonPanel.add(button);
//        set listener by using inner class
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try{
//                  provide lookandfeel name
                    UIManager.setLookAndFeel(classname);
//                  update the panel
                    SwingUtilities.updateComponentTreeUI(buttonPanel);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }


}
