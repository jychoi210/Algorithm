package programmers;

public class keypad {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 | numbers[i] == 4 | numbers[i] == 7) {
                answer = answer + "L";
                left = numbers[i];
            }
            else if(numbers[i] == 3 | numbers[i] == 6 | numbers[i] == 9) {
                answer = answer + "R";
                right = numbers[i];
            }
            else {
                int leftValue = Math.abs(numbers[i] - left);
                int rightValue = Math.abs(right - numbers[i]);

                System.out.println("value is : " + numbers[i] + "   leftValue is : " + leftValue + "    rightValue is : " + rightValue + "   left is : " + left + " rigth is : " +right);
                if(rightValue % 3 == 0) rightValue = rightValue/3;
                if(leftValue % 3 == 0) leftValue = leftValue/3;
                if(i == 0 | (leftValue == rightValue) | (Math.abs(rightValue - leftValue) == 2) ) {
                    String temp = hand.equals("right") ? "R" : "L";
                    if (temp == "R"){ right = numbers[i]; }
                    else{ left = numbers[i]; }
                    answer = answer + temp;
                }else{
                    if(leftValue < rightValue){
                        answer = answer + "L";
                        left = numbers[i];
                    }else if (leftValue > rightValue){
                        answer = answer + "R";
                        right = numbers[i];
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String args[]){
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
}
