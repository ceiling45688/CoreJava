package chapterfive;

/**
 * @author ceiling
 * @date 2019/2/5
 */
public class ParameterPassValue {
    int x;
    public static void change(ParameterPassValue a){
        a.x = 100;
        System.out.println("方法中x的值为： " + a.x );
    }
    public static void main(String[] args){
        ParameterPassValue a = new ParameterPassValue();
        a.x = 5;
        System.out.println("方法调用前x的值： "+ a.x);
        change(a);
        System.out.println("方法调用后x的值：" + a.x);
        //注意：类是一个引用类型，则通过类实例出的对象，传达的时候传的是地址
    }
}
