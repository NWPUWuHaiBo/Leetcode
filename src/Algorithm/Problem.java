package Algorithm;


import java.util.Map;

/**
 * @author haiboWu
 * @create 2020-07-04 11:05
 */
public class Problem {
    //表示顶点的个数
//    public static int N = 4;
//    //记录路径
//    public static int path[][] = new int[1024][20];
//    //存图的数据
//    public static int dis[][] = {{0, 8, 5, 36},
//            {6, 0, 8, 5},
//            {8, 9, 0, 5},
//            {7, 7, 8, 0}};
    //表示从点i到访问完集合V所需要的最短距离
    public static int count = 0;     //定义全局变量，用于计算当前已行走方案次数，初始化为0
    public static int MinDistance = 1000;    //定义完成一个行走方案的最短距离，初始化为100（PS：100此处表示比实际要大很多的距离）
    public static int[][] distance = {{0, 8, 5, 36},
            {6, 0, 8, 5},
            {8, 9, 0, 5},
            {7, 7, 8, 0}};   //使用二维数组的那个音图的路径相关距离长度

    /*
     * start为开始进行排序的位置
     * step为当前正在行走的位置
     * n为需要排序的总位置数
     * Max为n!值
     */
    public static void Arrange(int[] A, int start, int step, int n, int Max) {
        if (step == n) {   // 当正在行走的位置等于城市总个数时
            ++count;           //每完成一次行走方案，count自增1
            printArray(A);     //输出行走路线方案及其总距离
        }
        if (count == Max)
            System.out.println("已完成全部行走方案！！！,最短路径距离为:" + MinDistance);
        else {
            for (int i = start; i < n; i++) {
                /*第i个数分别与它后面的数字交换就能得到新的排列,从而能够得到n!次不同排序方案
                 */
                swapArray(A, start, i);
                Arrange(A, start + 1, step + 1, n, Max);
                swapArray(A, i, start);
            }
        }
    }

    //交换数组中两个位置上的数值
    public static void swapArray(int[] A, int p, int q) {
        int temp = A[p];
        A[p] = A[q];
        A[q] = temp;
    }

    //输出数组A的序列，并输出当前行走序列所花距离，并得到已完成的行走方案中最短距离
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++)   //输出当前行走方案的序列
            System.out.print(A[i] + "  ");

        int tempDistance = distance[A[0]][A[3]];     //此处是因为，最终要返回出发地城市，所以总距离要加上最后到达的城市到出发点城市的距离
        for (int i = 0; i < (A.length - 1); i++)   //输出当前行走方案所花距离
            tempDistance += distance[A[i]][A[i + 1]];

        if (MinDistance > tempDistance)   //返回当前已完成方案的最短行走距离
            MinDistance = tempDistance;

        System.out.println("  行走路程总和：" + tempDistance);
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 3};
        Arrange(A, 0, 0, 4, 24);    //此处Max = 4!=24
    }
}
