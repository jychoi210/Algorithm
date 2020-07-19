package problem1;

// 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘
// 자료구조 사용하여 풀기
// idea 2
// 입력 받은 문자열을 ArrayList에 저장한 후, hashSet, linkedHashSet, treeSet을 사용하여 중복을 제거한 후 크기가 같은지 확인한.
// 문자열 길이가 N이라면, 시간 복잡도는 O(N)이다.

/* 입력은 유니코드, 알파벳으로 가정한다. */
import java.util.*;

public class prob1_checkDuplicate_2 {
    public static void main(String args[]){
        ArrayList<String> data = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        s = s.replace(" ","");
        String[] A = s.split("");
        for(String temp: A){
            data.add(temp);
            hashSet.add(temp);
            linkedHashSet.add(temp);
            treeSet.add(temp);
        }

        System.out.println(hashSet);

        System.out.println(hashSet.size());
        System.out.println(data.size());
        System.out.println(hashSet.size() == data.size() ? "false" : "true");
        System.out.println(linkedHashSet.size() == data.size() ? "false" : "true");
        System.out.println(treeSet.size() == data.size() ? "false" : "true");

    }
}
