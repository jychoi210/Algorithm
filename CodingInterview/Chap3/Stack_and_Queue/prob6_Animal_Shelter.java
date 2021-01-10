package Chap3.Stack_and_Queue;

import java.util.NoSuchElementException;

class MyQueue<String>{
    class QueueNode{
        String data;
        int num;
        QueueNode next;
        public QueueNode(String data, int num){
            this.data = data;
            this.num = num;
        }
    }

    QueueNode first;
    QueueNode last;

    public void add(String item, int num){
        QueueNode t = new QueueNode(item, num);
        if(last != null){
            last.next = t;
        }
        last = t;
        if(first == null){
            first = last;
        }
    }

    public String remove(){
        if(first == null) throw new NoSuchElementException();
        String data = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }
        return data;
    }

    public String peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
public class prob6_Animal_Shelter {
    public static class AnimalShelter{
        MyQueue dogQueue;
        MyQueue catQueue;
        int num;

        public AnimalShelter(){
            dogQueue = new MyQueue();
            catQueue = new MyQueue();
        }

        public void enqueue(String animal, String name){
            num++;
            if(animal.equals("dog")){
                dogQueue.add(name,num);

            }else{
                catQueue.add(name, num);
            }
        }

        public String dequeueDog(){
            return (String) dogQueue.remove();
        }

        public String dequeueCat(){
            return (String) catQueue.remove();
        }

        public String dequeueAny(){
            if(dogQueue.first.num < catQueue.first.num){
                return dequeueDog();
            }else{
                return dequeueCat();
            }
        }
    }

    public static void main(String args[]){
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue("dog","1");
        animalShelter.enqueue("dog","2");
        animalShelter.enqueue("cat","3");
        animalShelter.enqueue("dog","4");
        animalShelter.enqueue("cat","5");
        animalShelter.enqueue("cat","6");
        animalShelter.enqueue("dog","7");
        animalShelter.enqueue("cat","8");
        animalShelter.enqueue("dog","9");
        animalShelter.enqueue("dog","10");

        System.out.println(animalShelter.dequeueDog());
        System.out.println(animalShelter.dequeueDog());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueAny());
    }
}
