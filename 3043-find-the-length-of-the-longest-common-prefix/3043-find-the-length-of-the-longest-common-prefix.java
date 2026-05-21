class Solution {
    static class Trie{
        Trie[] next=new Trie[10];
    }
    private Trie root=new Trie();

    private void insert(int num){
        String s=String.valueOf(num);
        Trie node=root;
        for(char c: s.toCharArray()){
            int d=c-'0';
            if(node.next[d]==null){
                node.next[d]=new Trie();
            }
            node=node.next[d];
        }
    }

    private int search(int num){
        String s=String.valueOf(num);
        Trie node=root;
        int len=0;
        for(char c: s.toCharArray()){
            int d=c-'0';
            if(node.next[d]==null) break;
            len++;
            node=node.next[d];
        }
        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int a: arr1){
            insert(a);
        }

        int res=0;
        for(int a:arr2){
            res=Math.max(res, search(a));
        }

        return res;
    }
}