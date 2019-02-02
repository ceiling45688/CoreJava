package chapterfour;

/**
 * @author ceiling
 * @date 2019/2/2
 */
public class ArrayCopy {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = new int[5];
        System.out.println("复制之前b[]");
        for (int k=0; k<b.length; k++) {
            System.out.print(b[k] + "\t");
        }
        System.arraycopy(a,0,b,0,a.length);
        System.out.println();
        System.out.println("复制之后b[]");
        for (int k=0; k<b.length;k++) {
            System.out.print(b[k] + "\t");
        }
    }
}
