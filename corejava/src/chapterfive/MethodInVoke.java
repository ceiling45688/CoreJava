package chapterfive;

/**
 * @author ceiling
 * @date 2019/2/4
 */
public class MethodInVoke {
    public void a(){
        System.out.println("调用a方法");
        b();
    }
    public void b(){
        System.out.println("调用b方法");
    }
    public static void main(String[] args){
        System.out.println("调用main方法");
        MethodInVoke mik = new MethodInVoke();
        mik.a();
        System.out.println("main方法结束");
    }
}
