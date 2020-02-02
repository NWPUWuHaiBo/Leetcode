package part1;

/**
 * @author haiboWu
 * @create 2020-02-01 20:08
 */
public class No_10 {
    public static void main(String[] args) {
        String s="abab";
        String p="*";
        System.out.println(isMatch(s, p));
    }
    public static boolean isMatch(String s,String p){
        int m=s.length(),n=p.length();
        //创建表
        boolean [][]f=new boolean[m+1][n+1];

        f[0][0]=true;
        for (int i = 2; i <=n ; i++) {
            f[0][i]=f[0][i-2]&&p.charAt(i-1)=='*';
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'){
                    f[i][j]=f[i-1][j-1];
                }
                if(p.charAt(j-1)=='*'){
                    f[i][j]=f[i][j-2]||f[i-1][j]&&(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.');
                }
            }
        }
        return f[m][n];
    }
}
