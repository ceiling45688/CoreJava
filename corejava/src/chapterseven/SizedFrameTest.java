package chapterseven;

import javax.swing.*;

import java.awt.*;

/**
 * @author ceiling
 * @date 2019/3/25
 * tips:  关于swing中事件调度线程的资料：http://www.importnew.com/15761.html
 */
public class SizedFrameTest {
    public static void  main (String[] args){
        /**
         * 所有的swing组件必须有时间调度线程进行配置，
         * invokeLater()这里知道是可以启动swing程序的入口就行。
         */
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
//      获取屏幕的尺寸
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
//      以下两句等同于 frame.setLocation(screenWidth/2, screenHeight/2)
        setSize(screenWidth / 2 , screenHeight / 2);
        setLocationByPlatform(true);
//        jdk1.4后设定一个窗体的相对于另外一个窗体的位置（通常是居中于父窗体的中间）
//        使用setLocationRelativeTo(owner); owner= null时为居中
        setLocationRelativeTo(null);
//      图片显示有问题？？
        Image img = kit.getImage("image\\乖巧.jpg");
        setIconImage(img);
        setTitle("SizedFrame");

    }
}
