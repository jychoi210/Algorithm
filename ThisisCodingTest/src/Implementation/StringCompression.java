package Implementation;

// 이것이 코딩 테스트다.
// Chapter 12 : 구현 기출 3 문자열 압축
// 프로그래머스 2020 카카오 신입 공채 (level 2)
// https://programmers.co.kr/learn/courses/30/lessons/60057

// 비교할 문자열 처리할 때 substring 말고 for문 이용 (substring은 얼마나 남았는지 모르기 때문에 for문의 if문을 사용함)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder compress = new StringBuilder();
        // 문자열 입력 받기
        String s = br.readLine();

        // 출력할 값 문자열 길이로 초기화
        int answer = s.length();

        // 1 ~ (문자열 길이 / 2)까지 문자를 나누어 비교
        for(int i =1; i <= s.length()/2; i++){
            compress = new StringBuilder();
            // 기준 문자열
            String temp = s.substring(0,i);
            // count=1으로 초기화
            int count = 1;
            // j = i 부터 i개 만큼 (1개씩 문자열 자르면 1부터 2까지)
            for(int j = i; j < s.length(); j+=i){
                String sub = "";
                // 비교할 문자열 s.length()의 끝까지 비교할 수 있도록 for문과 if문을 사용
                for (int k = j; k < j + i; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }

                // 기준 문자열과 비교 문자열이 같다면 count 증가
                if(temp.equals(sub)){
                    count++;
                }

                // 기준 문자열과 비교 문자열이 다르다면
                else{
                    //count가 1보다 크면, 즉 기준 문자열이 1번 이상 반복되었다면
                    //compress에 count 추가
                    if(count > 1) compress.append(count);
                    //compress에 기준 문자열 추가
                    compress.append(temp);
                    // 기준 문자열을 sub으로 다시 설정
                    temp = sub;
                    //count 1로 초기화
                    count = 1;
                }
            }

            //남은 문자열 처리
            // count가 1보다 크면 compress에 count 추가
            if(count > 1) compress.append(count);
            // compress에 temp 추가
            compress.append(temp);
            //answer와 compress 길이 중 더 작은 것을 answer로 선택
            answer = Math.min(answer, compress.length());
        }

        System.out.print(answer);
    }
}
