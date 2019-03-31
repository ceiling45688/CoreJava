package chapterseven;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author ceiling
 * @date 2019/3/31
 *
 * tips : 关于相对路径这个问题这里老没对。。！！！烦死了。
 */
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageFrame frame = new ImageFrame();
//                关闭frame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                显示
                frame.setVisible(true);
            }
        });
    }
}
class ImageFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 400;

    public ImageFrame() {
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        ImageComponent component = new ImageComponent();
        add(component);
    }
}
class ImageComponent extends JComponent {
    private String filename = "D:\\+++++++++++++Soft2++++++++++\\IDEA\\javaproject\\corejava\\src\\chapterseven\\image\\乖巧.jpg";
//    private String filename2 = "../image/乖巧.jpg";  ???????
    private Image image ;
    public ImageComponent(){
        try {
            image = ImageIO.read(new File(filename));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void paintComponent (Graphics g){

        g.drawImage(image,0, 0, null);
    }
}