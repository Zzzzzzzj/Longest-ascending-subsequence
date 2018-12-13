import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * 错误思考方式
 */
public class test1 {

    private static int math[]=new int[7];

    private static int length[]=new int[7];

    public static void init(){
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
        }catch (Exception e){
            e.getStackTrace();
        }


    }


    public static void main(String[] args){
        init();
        int i=0;
        for (i=0;i<math.length;i++){
            int m;
            int count=0;
            for (m=i;m<math.length;m++){
                if (m==i){
                    count++;
                }
                else if (math[m]>math[i]){
                    count++;
                }
                if (m==math.length-1){
                    length[i]=count;
                }
            }
        }
        for (int m:length){
            System.out.println(m);
        }
    }

}
