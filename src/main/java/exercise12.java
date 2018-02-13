import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zy812818
 * Created @ 2018/2/13.
 * leetcode 394. Decode String
 **/
public class exercise12 {

    public String decodeString(String s) {
        String repeatedStr ="";
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ']'){
                String current = "";
                while(!((current = stack.pop()).equals("["))){
                    repeatedStr=  repeatedStr + current;
                }
                String times = "";
                while(!stack.empty()){
                    current = stack.peek();
                    if(Character.isDigit(current.charAt(0))){
                        stack.pop();
                        times+=current;
                    }else{
                        break;
                    }
                }

                String rStr = "";
                for(int j = 0; j< Integer.parseInt(this.reverse(times)); j++){
                    rStr +=repeatedStr;
                }
                stack.push(rStr);
                repeatedStr = "";
            }else{
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        String current = "";
        String result ="";
        while(!stack.empty()){
            current = stack.pop();
            result+=current;
        }
        return this.reverse(result);
    }

    public static void main(String[] args){
        exercise12 exercise12 = new exercise12();
        System.out.println(exercise12.decodeString("sd2[f2[e]g]i"));
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1 ; i >=0 ; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
