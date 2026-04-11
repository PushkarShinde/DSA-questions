class Solution {
    public String nearestPalindromic(String n){
        long num=Long.parseLong(n);
        int len=n.length();

        Set<Long> nums=new HashSet<>();
        nums.add((long)Math.pow(10,len-1)-1);//n-1 me sabhse bada pal
        nums.add((long)Math.pow(10,len)+1);//n+1 me sabhse chota pal
        
        long prefix=Long.parseLong(n.substring(0,(len+1)/2));
        for(long i=-1;i<=1;i++){
            String p=String.valueOf(prefix+i);
            String str=generatePal(p,len%2==0);
            nums.add(Long.parseLong(str));
        }

        nums.remove(num);//khud ke bina
        long res=-1;
        long minDif=Long.MAX_VALUE;
        for(long candy: nums){
            long diff=Math.abs(candy-num);
            if(diff<minDif){
                minDif=diff;
                res=candy;
            }else if(diff==minDif){
                res=Math.min(candy, res);
            }
        }

        return String.valueOf(res);
    }

    private String generatePal(String s, boolean even){
        StringBuilder res=new StringBuilder(s);
        String rev=new StringBuilder(s).reverse().toString();
        if(even){
            return res.append(rev).toString();
        }else{
            return res.append(rev.substring(1)).toString();
        }
    }
}