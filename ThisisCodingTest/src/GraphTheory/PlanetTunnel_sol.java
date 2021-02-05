package GraphTheory;

// 이것이 코딩 테스트다.
// Chapter 18 : 그래프 이론 기출 4 행성 터널
// https://www.acmicpc.net/problem/2887

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Position implements Comparable<Position>{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Position other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}
class Dist implements Comparable<Dist>{
    int a;
    int b;
    int distance;

    public Dist(int a, int b, int distance){
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    @Override
    public int compareTo(Dist other){
        return Integer.compare(this.distance, other.distance);
    }
}

public class PlanetTunnel_sol {
    public static int n;
    public static int[] parent;
    public static int[] x, y, z;
    public static ArrayList<Dist> dists = new ArrayList<>();

    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ArrayList<Position> x = new ArrayList<Position>();
        ArrayList<Position> y = new ArrayList<Position>();
        ArrayList<Position> z = new ArrayList<Position>();
        parent = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xv = Integer.parseInt(st.nextToken());
            int yv = Integer.parseInt(st.nextToken());
            int zv = Integer.parseInt(st.nextToken());
            x.add(new Position(xv,i));
            y.add(new Position(yv,i));
            z.add(new Position(zv,i));
        }

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);

        for(int i = 0 ; i < n - 1; i ++){
            dists.add(new Dist( x.get(i).y, x.get(i+1).y, x.get(i + 1).x - x.get(i).x));
            dists.add(new Dist(y.get(i).y, y.get(i+1).y, y.get(i + 1).x - y.get(i).x));
            dists.add(new Dist(z.get(i).y, z.get(i+1).y, z.get(i + 1).x - z.get(i).x));
        }

        Collections.sort(dists);

        int result = 0;
        for(Dist d : dists){
            int a = d.a;
            int b = d.b;
            if(findParent(a) != findParent(b)){
                union(a, b);
                result += d.distance;
            }
        }

        System.out.print(result);

    }
}
