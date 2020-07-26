package Chap2.Linked_Lists;

// 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘
// 자료구조 사용하지 않고 풀기
// idea 1
// 입력 받은 문자열의 공백 제거 후, 앞 뒤로 글자가 같은지 확인한다.
// 문자열 길이가 N이라면, 시간 복잡도는 O(N)이다.

/* 입력은 유니코드, 알파벳으로 가정한다. */

import java.util.HashSet;

public class prob8_findLoop_Runner {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(4);
        linkedList.insertNode(5);
        linkedList.insertNode(6);
        ListNode node = linkedList.head;
        node.next.next.next.next.next = node.next.next;

        if(isHasLoop(node)){
            String result = (searchLoopNode(linkedList) != null ? ""+ searchLoopNode(linkedList).data : "No Loop");
            System.out.println(result);
        }
    }

    public static ListNode searchLoopNode(LinkedList linkedList){
        ListNode faster = linkedList.head;
        ListNode slower = linkedList.head;

        faster = faster.next.next;
        slower = slower.next;

        while(faster != null){
            if(faster == slower){
                break;
            }
            faster = faster.next.next;
            slower = slower.next;
        }

        slower = linkedList.head;

        while(faster != null){
            if(faster == slower){
                return faster;
            }
            faster = faster.next;
            slower = slower.next;
        }
        return null;

    }
    public static boolean isHasLoop(ListNode node){
        HashSet<ListNode> hashSet = new HashSet<>();
        while(node != null){
            if(!hashSet.contains(node)){
                hashSet.add(node);
            }else{
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
