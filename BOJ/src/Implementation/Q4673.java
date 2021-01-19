package Implementation;

// 백준 구현 Q4673 셀프넘버
// https://www.acmicpc.net/problem/4673
// 셀프 넘버 생성자가 없는 수 출력. 셀프넘버란 n + n의 각자 자리수의 합

public class Q4673 {
    public static void main(String args[]){
        //출력할 변수
        StringBuilder selfnum = new StringBuilder();
        boolean[] num = new boolean[10001];
        //1부터 10000까지 반복
        for(int n = 1; n <= 10000; n++){
            //n과 각 자리수 합 구하기
            int dn = n + (n % 10);
            if(n >= 10) dn += ((n % 100) / 10);
            if(n >= 100) dn += ((n % 1000) / 100);
            if(n >= 1000) dn += (n / 1000);
            //생성된 수가 10000보다 작을 경우 num[dn]을 true 설정
            if(dn <= 10000) num[dn] = true;
        }

        //1부터 10000까지 false인 것 selfnum에 넣음
        for(int i = 1; i <= 10000; i++){
            if(!num[i]) selfnum.append(i).append("\n");
        }

        System.out.print(selfnum);
    }
}
