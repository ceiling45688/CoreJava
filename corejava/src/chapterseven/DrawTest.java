package chapterseven;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @author ceiling
 * @date 2019/3/30
 * tips: 关于绘制2D图形：包括Line2D, Rectangle2D, Ellipse2D
 * (先创建2D对象，注意使用xx2D.double()方法，若用float方法，赋值时后要加F)
 * Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
 * Ellipse2D ellipse = new Ellipse2D.Double(centerX-width / 2, centerY - height / 2, width, height);
 * Line2D line = new Line2D.Double(startX,startY,endX,endY);
 * （然后调用Graphics2D的draw方法） ： g2.draw(rect);
 *
 * pps:在不需要节省存储空间时最好用.double方法，因为例如Rectangle2D方法的参数和返回值均为double类型，
 * 需要处理float类型的值，强制类型转换比较麻烦。
 */
public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawFrame frame = new DrawFrame();
//                关闭frame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                显示
                frame.setVisible(true);
            }
        });
    }
}
class DrawFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULET_HEIGHT = 400;
    public DrawFrame() {
        setTitle("DrawTest");
        setSize(DEFAULT_WIDTH, DEFAULET_HEIGHT);

        DrawComponent component = new DrawComponent();
        add(component);
    }
}
class DrawComponent extends JComponent {
    @Override public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

//        draw a rectangle
        double leftX = 50;
        double topY = 50;
        double width = 300;
        double height = 200;

        Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
        g2.draw(rect);
//      draw a ellipse
        double centerX = 200;
        double centerY = 150;
        Ellipse2D ellipse = new Ellipse2D.Double(centerX-width / 2, centerY - height / 2, width, height);
        g2.draw(ellipse);
//        draw a line
        double startX = leftX;
        double startY = topY;
        double endX = leftX+width;
        double endY = topY+height;
        Line2D line = new Line2D.Double(startX,startY,endX,endY);
        g2.draw(line);
    }
}
