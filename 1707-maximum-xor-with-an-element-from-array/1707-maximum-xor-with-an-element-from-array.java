class Solution {
    class Node{
        private Node[] links=new Node[2];

        public void put(int bit, Node node){
            links[bit]=node;
        }

        public Node get(int bit){
            return links[bit];
        }

        public boolean containsKey(int bit){
            return links[bit]!=null;
        }
    }

    class Trie{
        Node root=new Node();

        public void insert(int num){
            Node node=root;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                if(!node.containsKey(bit)){
                    node.put(bit, new Node());
                }
                node=node.get(bit);
            }
        }

        public int getMaxXor(int num){
            int maxXor=0;
            Node node=root;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                int opp=1-bit;
                if(node.containsKey(opp)){
                    maxXor |= (1<<i);
                    node=node.get(opp);
                }else{
                    node=node.get(bit);
                }
            }
            return maxXor;
        }

    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=queries.length;
        int[] res=new int[n];
        Arrays.sort(nums);

        int[][] q=new int[n][3];
        for(int i=0;i<n;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }

        Arrays.sort(q,(a,b)-> a[1]-b[1]);

        Trie trie=new Trie();
        int ind=0;
        for(int i=0;i<n;i++){
            int x=q[i][0];
            int m=q[i][1];
            int index=q[i][2];

            while(ind<nums.length && nums[ind]<=m){
                trie.insert(nums[ind]);
                ind++;
            }

            if(ind==0){
                res[index]=-1;
            }else{
                res[index]=trie.getMaxXor(x);
            }
        }
        return res;
    }
}