class Solution {
    /**
     * Correct Approach: Gale–Shapley Algorithm
    - Core idea:
        All men start free
        Each man proposes to women in order of preference
    - A woman:
        Accepts if free
        Otherwise keeps the better option (based on her ranking)
     */
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n=men.length;
        int[] partner=new int[n];
        Arrays.fill(partner,-1);
        
        int[] propose=new int[n];
        //ye banda kis next women ko propose karege

        int[][] rank=new int[n][n];
        //rank[w][m]=prefernce order of that man for that woman
        for(int w=0;w<n;w++){
            for(int j=0;j<n;j++){
                rank[w][women[w][j]]=j;
            }
        }

        Queue<Integer> freeMen=new LinkedList<>();
        for(int i=0;i<n;i++){
            freeMen.add(i);
        }
        
        while(!freeMen.isEmpty()){
            int m=freeMen.poll();
            int w=men[m][propose[m]++];
            
            if(partner[w]==-1){
                partner[w]=m;
            }else{
                int m2=partner[w];
                
                if(rank[w][m]<rank[w][m2]){
                    partner[w]=m;
                    freeMen.add(m2);
                }else{
                    freeMen.add(m);
                }
            }
        }
        
        int[] res=new int[n];
        for(int w=0;w<n;w++){
            res[partner[w]]=w;
        }
        
        return res;
    }
}