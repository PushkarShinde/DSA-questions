class Solution {
    public int minSteps(int m, int n, int d) {
        int g=gcd(m,n);
        if(d%g!=0) return -1;
        if(d>m && d>n) return -1;
        
        return Math.min(solve(m,n,d), solve(n,m,d));
    }
    
    private int solve(int m, int n, int tar){
        int from=m;//pehla bharenge
        int to=0;
        int step=1;
        
        while (from != tar && to != tar) {
            int temp = Math.min(from, n-to);//kitna bharna hai
            to+=temp;
            from-=tem p;
            step++;
            if(from==tar || to==tar) break;
            if(from==0){
                from=m;
                step++;
            }
            if(to==n){
                to=0;
                step++;
            }
        }
        return step;
    }
        /*
        Queue<int[]> qu=new LinkedList<>();
        Set<String> set=new HashSet<>();
        qu.offer(new int[]{0,0});
        set.add("0,0");
        
        int step=0;
        while(!qu.isEmpty()){
            int size=qu.size();
            while(size-->0){
                int[] cur=qu.poll();
                int x=cur[0], y=cur[1];
                if(x==d || y==d) return step;
                
                List<int[]> next=new ArrayList<>();
                
                //fill
                next.add(new int[]{m,y});
                next.add(new int[]{x,n});
                //empty
                next.add(new int[]{x,0});
                next.add(new int[]{0,y});
                //pour x to y
                int pour=Math.min(x, n-y);
                next.add(new int[]{x-pour,y+pour});
                //pour y to x
                pour=Math.min(m-x, y);
                next.add(new int[]{x+pour,y-pour});
                
                for(int[] val:next){
                    String key=""+val[0]+","+val[1];
                    if(!set.contains(key)){
                        set.add(key);
                        qu.offer(val);
                    }
                }
            }
            step++;
        }
        return -1;
        */
    
    private int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
}