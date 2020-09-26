import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_9935{
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String bomb = reader.readLine();

        String result = stringBomb(str,bomb);
        System.out.println((result.length()==0) ? "FRULA" : result);
    }

    public static String stringBomb(String str, String bomb) {
        Stack<Character> stack = new Stack<>();
        int bombLen = bomb.length();

        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));

            if(stack.size() >= bombLen){
                boolean flag = true;
                for(int j = 0; j < bombLen; j++){
                    if(stack.get(stack.size() - bombLen + j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j = 0; j < bombLen; j++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char temp : stack){
            sb.append(temp);
        }

        return sb.toString();
    }

}

