package Sorting;

// 이것이 코딩 테스트다.
// Chapter 6 : 정렬 문제 2 성적이 낮은 순서로 학생 출력하기
// 해답 코드

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    //낮은 순서 이므로 오름차순
    //내림 차순으로 하려면 this.score > o.score
    @Override
    public int compareTo(Student o) {
        if(this.score < o.score) return -1;
        return 1;
    }
}

public class StudentsInAscendingOrder_sol {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //n명의 학생 정보를 리스트에 저장
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).getName());
        }
    }
}
