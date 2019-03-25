package chapterseven;

import javax.swing.*;

import java.awt.*;

/**
 * @author ceiling
 * @date 2019/3/25
 * tips:
 */
public class SizedFrameTest {
    public static void  main (String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SizedFrame frame = new SizedFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class SizedFrame extends JFrame {
    public SizedFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2 , screenHeight / 2);
        setLocationByPlatform(true);

//        Image img = kit.getImage("./乖巧.jpg");
//        setIconImage(img);
        setTitle("SizedFrame");

    }
}
