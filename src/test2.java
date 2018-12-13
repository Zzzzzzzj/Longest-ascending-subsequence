import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 将问题分为子问题
 * 分成n个子问题
 * 解决n个子问题即解决问题
 * 求出每个数字的最长列队即可
 * 我为人人
 * 人人为人
 */

public class test2 {

    private static int[] lengthMax=new int[7];

    private static int[] math=new int[7];

    private static void init(){
        File file=new File("resource/math.properties");
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line=in.readLine();
            if (line!=null){
                String[] strs=line.split(",");
                int i=0;
                for (String str:strs){
                    int m=Integer.valueOf(str);
                    math[i]=m;
                    i++;
                }
            }
            for (int i=0;i<lengthMax.length;i++){
                lengthMax[i]=1;
            }
        }catch (Exception e){
            e.getStackTrace();
        }


    }

    public static void main(String[] args){
        init();
        for (int i=1;i<math.length;i++){
            for (int j=0;j<i;j++){
                if (math[i]>math[j]){
                    lengthMax[i]=Math.max(lengthMax[i],lengthMax[j]+1);
                }

            }

        }

        for (int i:lengthMax){
            System.out.println(i);
        }
    }

}
