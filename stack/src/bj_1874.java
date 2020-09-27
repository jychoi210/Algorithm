import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class bj_1874{
    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int comm = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        boolean check = true;
        int[] arr = new int[comm];
        int index = 1;

        for(int i = 0; i < comm; i++){
            int num = Integer.parseInt(reader.readLine());
            arr[i] = num;
        }


        for(int i = 0; i < comm; i++) {
            while(stack.size()==0 || stack.peek() < arr[i]){
                stack.push(index);
                index++;
                result.add('+');
            }
            if(stack.size() > 0 && stack.peek() == arr[i] && stack.size() != 0){
                stack.pop();
                result.add('-');
            }else{
                check = false;
            }
        }

        if(check){
            for(int i = 0; i < result.size(); i++){
                System.out.println(result.get(i));
            }
        }else{
            System.out.println("NO");
        }

    }
}
