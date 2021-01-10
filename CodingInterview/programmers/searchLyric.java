package programmers;

public class searchLyric {
    public static void main(String args[]){
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(solution(words, queries));
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] result =  new int[queries.length];
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < queries.length; i++) {
            for (String word : words) {
                if (word.length() == queries[i].length()) {
                    for(int j = 0; j < word.length(); j++){
                        if(word.charAt(j) == queries[i].charAt(j) || queries[i].charAt(j) == '?'){
                            flag = true;
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        count++;
                    }
                }
            }
            result[i] = count;
            count = 0;
        }

        return result;
    }

}
