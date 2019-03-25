package chapterseven;

import javax.swing.*;

/**
 * @author ceiling
 * @date 2019/3/25
 * tps:
 */
public class SimpleJFrameTest {
    public static void main(String[] args){
        SimpleFrame frame = new SimpleFrame();
//        关闭frame时的响应动作，默认隐藏frame，程序并未终止。
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        显示frame
        frame.setVisible(true);
    }
}
class SimpleFrame extends JFrame{
    public static final int DEFAULT_WIDTH  = 300;
    public static final int DEFAULT_HEIGHT = 200;
    public SimpleFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}