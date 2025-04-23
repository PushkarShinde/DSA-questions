class Solution {
    public int countLargestGroup(int n) {
        // HashMap<Integer> map=new HashMap<>();
        int[] map=new int[37];
        int maxVal=0;
        for(int i=1;i<=n;i++){
            int j = i % 10 + (i / 10) % 10 + (i / 100) % 10 + (i / 1000) % 10;
            map[j]++;
            maxVal=Math.max(maxVal, map[j]);
        }
        int res=0;
        for (int i = 0; i < 37; i++) {
            if (map[i] == maxVal) res++;
        }
        return res;
    }
}