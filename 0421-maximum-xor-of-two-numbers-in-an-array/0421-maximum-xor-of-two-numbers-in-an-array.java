class Solution {
    class Node{
        Node one;
        Node zero;
    }
    public int findMaximumXOR(int[] nums) {
        Node root=new Node();

        for(int i:nums){
            Node node=root;
            for(int j=31;j>=0;j--){
                if(((1<<j)&i)!=0){
                    if(node.one==null){
                        node.one=new Node();
                    }
                    node=node.one;
                }else{
                    if(node.zero==null){
                        node.zero=new Node();
                    }
                    node=node.zero;
                }
            }
        }

        int res=0;

        for(int i:nums){
            Node node=root;
            StringBuilder num=new StringBuilder();
            for(int j=31;j>=0;j--){
                if(((1<<j)&i)!=0){
                    if(node.zero==null){
                        node=node.one;
                        num.append(1);
                    }else{
                        node=node.zero;
                        num.append(0);
                    }
                }else{
                    if(node.one==null){
                        node=node.zero;
                        num.append(0);
                    }else{
                        node=node.one;
                        num.append(1);
                    }
                }
            }
            int number=Integer.parseInt(num.toString(),2);
            res=Math.max(res, number^i);
        }
        return res;
    }
}