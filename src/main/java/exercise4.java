import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zy812818
 * Created @ 2017/9/28.
 * 寻找变位词问题(桶排其实用了26byte，其实可以用26bit)
 **/
public class exercise4 {

    private HashMap<String,List<String>> map = new HashMap<String, List<String>>();

    public String bucketSort(String word){
        byte[] bucket = new byte[26];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++){
            bucket[word.charAt(i)-96]++;
        }
        for(char i=0;i<26;i++){
            for(char j=0;j<bucket[i];j++){
                char c = (char) (i+96);
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public String quickSort(String word){
        char[] words = word.toCharArray();
        quickSort(words,0,words.length-1);
        return String.valueOf(words);
    }

    public void quickSort(char[] words, int i, int j){
        if(i>=j)
            return;
        else{
            int left =i;
            int right =j;
            char c = words[left];
            while(i<j){
                while(words[j]>=c) {
                    if(j==i)
                        break;
                    j--;
                }

                while(words[i]<=c){
                    if(i==j)
                        break;
                    i++;

                }
                if(i!=j)
                    swap(words,i,j);
            }
            swap(words,left,i);
            quickSort(words,left,i-1);
            quickSort(words,i+1,right);
        }
    }

    public void swap(char[] words ,int i, int j){
            char tmp ;
            tmp = words[i];
            words[i] = words[j];
            words[j] = tmp;
    }


    public void find(String[] words){
        for(int i =0;i<words.length;i++){
            String sign = quickSort(words[i]);
//            String sign = bucketSort(words[i]);
            if(map.get(sign)==null){
                List<String> list = new ArrayList<String>();
                list.add(words[i]);
                map.put(sign,list);
            }else{
                List<String> list = map.get(sign);
                list.add(words[i]);
                map.put(sign,list);
            }
        }
    }

    public static void main(String[] args){
        exercise4 exercise4 = new exercise4();
        exercise4.find(new String[]{"pans","pots","opt","snap","stop","tops"});
        System.out.println(exercise4.map);
        char[] c = new char[]{'e','d','c','b','a'};
        exercise4.quickSort(c,0,4);
        System.out.println(String.valueOf(new int[]{1,2,3}));
        System.out.println("sdsa sds".substring(0,6));
    }

}
