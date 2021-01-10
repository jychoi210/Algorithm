//fastcampus 자료구조 강의 38
//Hash 해시 (체이닝 기법)

import java.util.Random;

class Student{
    int id;
    String name;

    public Student(int id){
        this.id = id;
        this.name = String.format("%d", id);
    }
}


public class Hash {
    Bucket[] hashTable;
    public static final int TABLE_SIZE = 10007;
    public static final int INPUT_SIZE = 5000;

    class Bucket{
        Student data;
        Bucket next;

        public Bucket(){
            this.data = null;
            this.next = null;
        }
    }

    public Hash(Bucket[] hashTable){
        this.hashTable = hashTable;
    }

    public void init(Bucket[] hashTable){
        for(int i = 0; i < TABLE_SIZE; i++){
            hashTable[i] = null;
        }
    }

    //메모리 반환. 자바에서는 가비지 컬렉션을 지원하지만 메모리 누수 방지를 위해 메모리 반환
    public void destructor(Bucket[] hashTable){
        for(int i = 0; i < TABLE_SIZE; i++){
            if(hashTable[i] != null){
                hashTable[i] = null;
            }
        }
    }

    //체이닝 데이터 탐색 함수
    public boolean isExist(Bucket[] hashTable, int id){
        int i = id % TABLE_SIZE;
        if(hashTable[i] == null) return false;
        else{
            Bucket cur = hashTable[i];
            while(cur != null){
                if(cur.data.id == id) return true;
                cur = cur.next;
            }
        }
        return false;
    }

    public void add(Bucket[] hashTable, Student input){
        int i = input.id % TABLE_SIZE;
        if(hashTable[i] == null){
            hashTable[i].data = input;
            hashTable[i].next = null;
        }
        else{
            Bucket cur = new Bucket();
            cur.data = input;
            cur.next = hashTable[i];
            hashTable[i] = cur;
        }
    }

    public void show(Bucket[] hashTable){
        for(int i = 0 ; i < TABLE_SIZE; i++){
            Bucket cur = hashTable[i];
            while(cur != null){
                System.out.println("키 : " + i + " 이름  : " + cur.data.name);
                cur = cur.next;
            }
        }
    }

    public static void main(String args[]){
        Bucket[] hashTable = new Bucket[TABLE_SIZE];
        Hash hash = new Hash(hashTable);
        hash.init(hashTable);
        Random rd = new Random();

        for(int i = 0; i < INPUT_SIZE; i++){
            int id = rd.nextInt(1000000);
            Student student = new Student(id);
            //System.out.println(rd.nextInt(1000000));
            student.name = String.format("%d", student.id);
            System.out.println(student.name + " 사람 " + student.id);
            System.out.println("1");
            if(!hash.isExist(hashTable, student.id)){
                System.out.println(student.id);
                hash.add(hashTable, student);
                System.out.println("2");
            }
            System.out.println("3");
        }

        hash.show(hashTable);
        hash.destructor(hashTable);
    }
}
