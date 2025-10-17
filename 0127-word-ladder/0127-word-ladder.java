class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        int m=wordList.size();
        int n=endWord.length();
        Queue<String> q=new LinkedList<>(); 
        q.offer(beginWord);
        int res=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur=q.poll();
                if(cur.equals(endWord)) return res;
                char[] arr=cur.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char original=arr[j];
                    for(char c='a';c<='z';c++){
                        arr[j]=c;
                        String next=new String(arr);
                        if(set.contains(next)) {
                            q.offer(next);
                            set.remove(next); // taki age firse select na ho jaye natkhat!
                        }
                    }
                    arr[j]=original;
                }
            }
            res++;
        }
        return 0;
    }
}