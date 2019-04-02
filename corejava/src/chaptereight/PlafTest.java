package chaptereight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ps: 只做练习，晚上回来重做一次
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

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos ){
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
    }

    void makeButton(String name, final String plafName){
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try{
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
