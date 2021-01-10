package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9935_sol {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        String answer = solution(str, bomb);
        System.out.println((answer.length() == 0) ? "FRULA" : answer);
    }

    private static String solution(String str, String bomb) {
        int index = 0;
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[index] = str.charAt(i);

            if (isBomb(result, index, bomb)) {
                index -= bomb.length();
                index++;
            }
        }
        return String.valueOf(result, 0, index);
    }

    private static boolean isBomb(char[] result, int index, String bomb) {
        if (index < bomb.length() - 1) return false;
        for (int i = 0; i < bomb.length(); i++) {
            if (bomb.charAt(i) != result[index - bomb.length() + 1 + i])
                return false;
        }

        return true;
    }
}
