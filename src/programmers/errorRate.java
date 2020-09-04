package programmers;

import java.util.*;

public class errorRate {
    public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];
        int[] player = new int[N+2];
        int[] clearPlayer = new int[N+2];
        double[] errorRate = new double[N];
        clearPlayer[0] = 0;
        clearPlayer[1] = stages.length;

        HashSet<Double> hashSet = new HashSet<>();

        for(int i = 0; i < stages.length; i++){
            player[stages[i]]++;
        }

        for(int i = 2; i < player.length; i++){
            clearPlayer[i] = clearPlayer[i-1] - player[i-1];
        }

        for(int i = 1; i < player.length-1; i++){
            if(player[i] == 0 & clearPlayer[i] ==0){

            }
            errorRate[i-1] = (double) player[i] / clearPlayer[i];
            hashSet.add(errorRate[i-1]);
        }

        int num = hashSet.size();
        int index = 0;
        for(int j = 0; j < num; j++) {
            double max = Collections.max(hashSet);
            System.out.println("max is " + max);
            for (int i = 0; i < errorRate.length; i++) {
                if (errorRate[i] == max) {
                    answer[index] = i+1;
                    System.out.println(" i is" + i + "   index is" + index);
                    index++;
                }
            }
            hashSet.remove(max);
        }

        for(int i : answer){
            System.out.println(i);
        }
        return answer;
    }
    public static void main(String args[]){
        solution(4, new int[]{4,4,4,4,4});
    }

}
