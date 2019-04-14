package chapternine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextComponentTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TextComponentFrame frame = new TextComponentFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class TextComponentFrame extends JFrame {
    public TextComponentFrame() {
        setTitle("Text");
        setSize(400,600);

        final JTextField textField = new JTextField();
        final JPasswordField passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new Label("username:",SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new Label("password:"),SwingConstants.RIGHT);
        northPanel.add(passwordField);

        add(northPanel,BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(8,40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);


        JPanel southPanel = new JPanel();
        JButton insertButton = new JButton("insert");
        southPanel.add(insertButton);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                textArea.append("username:"+textField.getText()+ "password:" + new String(passwordField.getPassword())+ "\n");
            }
        });
        add(southPanel,BorderLayout.SOUTH);
    }
}
