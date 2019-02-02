package chapterfour;
/**
 * @author ceiling
 * @date 2019/2/2
 */
public class MaoPao {
    /**
     * 冒泡算法基础版：外层循环n-1，内层循环n-1-i。
     */
    public static void main(String[] args){
        int[] a = {1,8,6,5,7,9,2};
        for (int i=0 ;i<a.length-1; i++){
            for (int j=0; j<a.length-1-i; j++){
                if(a[j] > a[j+1]){
                    int temp;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"轮后：");
            for (int k=0;k<a.length; k++) {
                System.out.print(a[k] + "\t");
            }
            System.out.println();
        }
        System.out.println("交换后:");
        for (int i=0; i<a.length;i++) {
            System.out.print(a[i] + "\t");
        }
    }
}
