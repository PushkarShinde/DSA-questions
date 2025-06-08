class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<>();
        for(int init=1;init<10;init++){
            solve(init,n,list);
        }
        return list;
    }
    /**
    The code uses a depth-first search (DFS) approach to generate numbers by building them digit by digit, 
    starting from 1 to 9 and appending digits (0 to 9) to form larger numbers.
     */
    private void solve(int curr, int n, List<Integer> list){
        if(curr>n) return;
        list.add(curr);
        for(int append=0;append<10;append++){
            int newNum=curr*10+append;
            if(newNum>n) return;
            solve(newNum, n, list);
        }
    }
}