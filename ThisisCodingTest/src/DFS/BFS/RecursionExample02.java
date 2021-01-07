package DFS.BFS;

public class RecursionExample02 {
    //팩토리얼 반복적으로 구현하기
    public static int factorial_iterative(int n){
        int result = 1;
        for(int i = 1; i < n; i++){
            result *= i;
        }

        return result;
    }

    //팩토리얼 재귀적으로 구현하기
    public static int factorial_recursion(int n){
        if(n <= 1) return 1;
        return n * factorial_recursion(n - 1);
    }

    public static void main(String args[]){
        System.out.println(factorial_iterative(5));
        System.out.println(factorial_recursion(5));
    }
}
