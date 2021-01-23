package DFS.BFS;

// 이것이 코딩 테스트다.
// Chapter 13 : DFS, BFS 기출 5 연산자 끼워넣기
// https://www.acmicpc.net/problem/14888

//완전 탐색 방법 -> 시간이 너무 많이 걸림
//중복된 것이 있으므로 순열 -> 중복 순열로도 구현 가능

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Permutation {
    private int n;
    private int r;
    private int[] now; // 현재 순열
    private ArrayList<ArrayList<Integer>> result; // 모든 순열

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) {
        // 현재 순열의 길이가 r일 때 결과 저장
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}

public class InsertOperator {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> num = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num.add(Integer.parseInt(st.nextToken()));
        }

        int[] operator = new int[n-1];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        for(int i = 0; i < 4; i++){
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0; j < t; j++){
                operator[index++] = i;
            }
        }

        Permutation perm = new Permutation(n-1,n-1);
        perm.permutation(operator,0);
        ArrayList<ArrayList<Integer>> list = perm.getResult();

        int max = (int)1e9 * -1;
        int min = (int)1e9;
        int val = 0;

        for(int i = 0; i < list.size(); i++){
            int a = num.get(0);
            for(int j = 0; j < list.get(i).size(); j++) {
                a = calculate(a,num.get(j+1),list.get(i).get(j));
                val = a;
            }
            if(max < val) {
                max = val;
            }
            if(min > val) {
                min = val;
            }
        }
        System.out.println(max);
        System.out.println(min);

    }
    public static int calculate(int a, int b, int o){
        if(o == 0) return a + b;
        else if(o == 1) return a - b;
        else if(o == 2) return a * b;
        else{
            if(a < 0 && b > 0) {
                a = a * -1;
                return (a / b) * -1;
            }
            else if(a > 0 && b < 0){
                b = b * -1;
                return (a / b) * -1;
            }
            else if(a < 0 && b < 0){
                a = a * -1;
                b = b * -1;
                return a / b;
            }
            else return a / b;
        }
    }
}
