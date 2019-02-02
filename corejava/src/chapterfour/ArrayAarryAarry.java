package chapterfour;
/**
 * @author ceiling
 * @date 2019/2/2
 */
public class ArrayAarryAarry {
/**
 * 三维数组
 */
    public static void main(String[] args) {
        int[][][] arr = {
                {{1,0}, {2,0}}, {{3, 4}, {5, 6}}
        };
    for (int i=0; i<arr.length ;i++){
        for (int j=0; j<arr[0].length; j++){
            for (int k=0 ;k<arr[0][0].length;k++){
                System.out.print(arr[i][j][k]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    }
}
