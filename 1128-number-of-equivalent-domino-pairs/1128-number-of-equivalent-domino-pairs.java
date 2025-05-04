/**
Created a custom generic pair class to use in solution 
 */
public class Pair<K, V>{
    public K first;
    public V second;

    public Pair(K first, V second){
        this.first=first;
        this.second=second;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
               Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        /*// My BRUTE APPROACH O(N^2)
        int n=dominoes.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            int a=dominoes[i][0];
            int b=dominoes[i][1];
            for(int j=i+1;j<n;j++){
                int c=dominoes[j][0];
                int d=dominoes[j][1];
                if((a == c && b == d) || (a == d && b == c)){
                    count++;
                }
            }
        }
        return count;
        */
        
        int n=dominoes.length;
        int count=0;
        HashMap<Pair<Integer, Integer>, Integer> map=new HashMap<>();
        for(int[] dom: dominoes){
            int a=dom[0];
            int b=dom[1];
            if(a>b){ // swap to make a <=b for our ease
                int temp=a;
                a=b;
                b=temp;
            }
            Pair<Integer, Integer> p=new Pair<>(a,b);
            count+=map.getOrDefault(p,0);
            map.put(p,map.getOrDefault(p,0)+1);
        }
        return count;
    }
}

/**
MOST OPTIMISED
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] dp = new int[10][10];

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            dp[a][b]++;
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                int freq = dp[i][j];
                if (freq >= 2) {
                    count += freq * (freq - 1) / 2;
                }
            }
        }

        return count;
    }
}

 */