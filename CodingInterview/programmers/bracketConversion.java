package programmers;
/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  4-3. ')'를 다시 붙입니다.
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  4-5. 생성된 문자열을 반환합니다.
 */

public class bracketConversion {
    public static void main(String args[]){
        System.out.println(solution("(()())()"));
        System.out.println(solution("()))((()"));
        System.out.println(solution(")("));
    }

    //이미 올바른 괄호 문자열이라면 그대로 리턴, 아니라면 괄호변환 후 리턴
    public static String solution(String p){
        if(checkCorrect(p)){
           return p;
        }else{
            return conversion(p);
        }
    }

    //올바른 괄호 문자열 확인 함수
    public static boolean checkCorrect(String str){
        int bool = 0;
        for(int i = 0; i < str.length(); i++){
            bool = str.charAt(i) == '(' ? bool+1 : bool-1;

            if(bool < 0){ return false;}
        }
        if(bool == 0){ return true; }
        return false;
    }

    //4-4를 위한 함수
    public static String reverse(String u){
        String result = "";
        for(int i = 1; i < u.length() - 1; i++){
            result = u.charAt(i) == '(' ? result + ")" : result + "(";
        }
        return result;
    }

    //1~4를 반복하여 올바른 괄호 문자열을 만들어 리턴하는 함수
    public static String conversion(String str){
        int bool = 0;
        String u = "";
        String v = "";
        StringBuilder temp = new StringBuilder();
        if(str.equals("")){
            return str;
        }else{
            for(int i = 0; i < str.length(); i++){
                bool = str.charAt(i) == '(' ? bool+1 : bool-1;

                if(bool == 0){
                    u = str.substring(0,i+1);
                    v = str.substring(i+1);
                    break;
                }
            }
        }

        if(checkCorrect(u)){
            temp.append(u);
            temp.append(conversion(v));
            return String.valueOf(temp);
        }else{
            temp.append("(");
            temp.append(conversion(v));
            temp.append(")");
            temp.append(reverse(u));
            return String.valueOf(temp);
        }
    }
}
