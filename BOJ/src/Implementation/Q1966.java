package Implementation;

// 백준 구현 Q1966 프린터 큐
// https://www.acmicpc.net/problem/1966
// 우선순위가 높은 것 부터 뽑아야 하며, 특정 문서의 프린트 순서 출력하기

import java.io.*;
import java.util.*;

public class Q1966 {
    public static int n, m, print, max, temp;
    public static ArrayList<Integer> queue;
    public static void main(String agrs[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //테스트 케이스 수 입력 받기
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 만큼 반복
        for(int t = 0; t < test; t++){
            st = new StringTokenizer(br.readLine());
            // m, n 입력 받기
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            // ArrayList 생성
            queue = new ArrayList<Integer>();

            st = new StringTokenizer(br.readLine());

            // m까지 큐에 넣기
            for(int i = 0; i < m; i++){
                queue.add(Integer.parseInt(st.nextToken()));
            }

            // m이 0이거나 1이면 print 출력
            if(m == 1 || m == 0) print = m;
            else {
                // 프린트 변수 초기화
                print = 0;
                // 현재 가장 큰 수 max에 저장
                max = Collections.max(queue);
                // queue가 빌 때 까지 반복
                while (queue.size() != 0) {
                    // 리스트의 처음 숫자가 우선 순위가 가장 크다면, 즉 프린트 해야 한다면
                    if (queue.get(0) == max) {
                        // 프린트 하기
                        print++;
                        // 찾는 프린트물의 순서가 0이라면, 즉 찾는 프린트 물이 프린트 됐다면
                        if (n == 0) {
                            // 멈춤
                            break;
                        }
                        // 큐의 맨 앞 삭제
                        queue.remove(0);
                        // 순위 하나 당김
                        n--;
                        // 리스트에 아무것도 없지 않으면, max 값 갱신
                        if(queue.size()!=0) max = Collections.max(queue);
                    } else {
                        // 리스트 맨 앞 숫자를 temp에 저장
                        temp = queue.get(0);
                        // 맨 앞 숫자 삭제하고
                        queue.remove(0);
                        // 맨 뒤로 보내기
                        queue.add(temp);

                        // 맨 뒤로 보낸 것이 찾는 프린트 물이라면,
                        if (n == 0) {
                            // n의 순서를 queue의 사이즈로 갱신
                            n = queue.size();
                        }
                        // 순위 하나 당김
                        n--;
                    }

                }
            }
            // sb에 프린트 되는 순서 붙임
            sb.append(print).append("\n");
        }
        System.out.print(sb.toString());
    }
}