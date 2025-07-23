class Solution {
    public static void print_divisors(int n) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if (n % i == 0) {
                res.add(i);
                int other = n / i;
                if (other != i) res.add(other);
            }
        }
    
        // Remove duplicates if any (e.g., when n is a square like 49)
        Collections.sort(res);
        
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
