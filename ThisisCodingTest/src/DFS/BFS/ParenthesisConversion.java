package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 12 : DFS, BFS 기출 4 괄호 변환
// 프로그래머스 2020 카카오 신입 공채 1차
// https://programmers.co.kr/learn/courses/30/lessons/60058

public class ParenthesisConversion {
    //괄호 방향 뒤집는 함수
    public static String reverse(String p){
        String result = "";
        for(int i = 0; i < p.length(); i++){
            result = p.charAt(i) == ')' ? result + "(" : result + ")";
        }
        return result;
    }
    //올바른 괄호 문자열인지 판단하는 함수
    public static boolean correct(String p){
        int num = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') num++;
            if(p.charAt(i) == ')') num--;
            if(num < 0) return false;
        }
        return true;
    }
    //괄호 변환 함수
    public static String conversion(String p){
        int num = 0;
        String u = "", v = "";
        //1. 입력이 빈 문자열인 경우, 빈 문자열 반환
        if(p.isEmpty()) return p;
        //2. w를 균형잡힌 괄호 문자열 u,v로 분리, 단, u는 더 이상 분리할 수 없는 균형잡힌 괄호 문자열
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') num++;
            if(p.charAt(i)==')') num--;
            if(num == 0){
                u = p.substring(0,i+1);
                v = p.substring(i+1);
                break;
            }
        }
        //3. 수행한 결과 문자열을 u에 이어 붙인 후 반환
        // 3-1. 문자열 u가 올바른 괄호 문자열이라면 문자열 v에 대해 다시 수행
        if(correct(u)) {
            return u + conversion(v);
        }
        //4. 문자열 u가 올바른 괄호 문자열이 아니라면
        else{
            StringBuilder temp = new StringBuilder();
            // 4-1. 빈 문자열에 첫 번째 문자로 "("를 붙임
            temp.append("(");
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙임
            temp.append(conversion(v));
            // 4-3. ")"를 붙인다.
            temp.append(")");
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고
            u = u.substring(1,u.length()-1);
            // 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임
            temp.append(reverse(u));
            // 4-5. 생성된 문자열 반환
            return temp.toString();
        }
    }
    public static void main(String args[]) {
        System.out.println(conversion("(()())()"));
        System.out.println(conversion(")("));
        System.out.println(conversion("()))((()"));
        System.out.println(conversion(""));
    }
}
