package programmers;

class Node{
    private String character;
    private int value;
    private Node[] children;
    private boolean leaf;

    public Node(String character) {
        this.character = character;
        this.children = new Node[26];
    }

    public Node getChild(int index){
        return children[index];
    }

    public void setChild(int index, Node node, int value){
        node.setValue(value);
        this.children[index] = node;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Trie{
    private Node root;
    private int indexOfSingleChild;

    public Trie(){
        this.root = new Node("");
    }

    private int transformASCIIIndex(char c){
        return c - 'a';
    }

    public void insert(String key, int value){
        Node tempNode = root;

        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            int asciiIndex = transformASCIIIndex(c);

            if(tempNode.getChild(asciiIndex) == null){
                Node node = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex,node, value);
                tempNode = node;
            }else{
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
    }

    public boolean search(String key){
        Node trieNode = root;
        for(int i = 0; i < key.length(); i++){
            int asciiIndex = transformASCIIIndex(key.charAt(i));
            if(trieNode.getChild(asciiIndex) == null){
                return false;
            }else{
                trieNode = trieNode.getChild(asciiIndex);
            }
        }
        return true;
    }
}

public class searchLyric_trie {
    public static void main(String args[]){
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(solution(words, queries));
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] result = new int[queries.length];
        int count = 0;
        boolean flag = false;

        Trie trie = new Trie();
        for (int i = 0; i <words.length; i++){
            trie.insert(words[i], i);
        }

        return result;
    }
}
