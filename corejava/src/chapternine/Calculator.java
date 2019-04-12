package chapternine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author ceiling
 * @date 2019/4/12
 * tips: FlowLayout 默认流布局维持每个组件的最佳尺寸，BorderLayout边框布局会扩展所有组件的尺寸以便填满可用空间。
 */
public class Calculator {
}
class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}
class CalculatorPanel extends JPanel {
    private JPanel panel;
    private JButton display;
    private double result;
    private String lastCommand;
    private boolean start;

    public CalculatorPanel() {
//        设置边框布局对象
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display,BorderLayout.NORTH);


        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        addButton("7", insert);
    }
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton();
        button.addActionListener(listener);
        panel.add(button);
    }
}