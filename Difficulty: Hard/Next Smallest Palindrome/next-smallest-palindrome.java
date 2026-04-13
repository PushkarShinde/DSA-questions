class Solution {
    static int[] nextPalindrome(int[] num) {
        int n=num.length;
        boolean allNine=true;
        for(int i:num){
            if(i!=9){
                allNine=false;
                break;
            }
        }
        
        if(allNine){
            int[] res=new int[n+1];
            res[0]=res[n]=1;
            return res;
        }
        
        int mid=n/2;
        boolean inc=false;
        int left=mid-1;
        int right=(n%2==0)?mid:mid+1;
        
        while(left>=0 && num[left]==num[right]){
            left--;
            right++;
        }
        
        if(left<0 || num[left]<num[right]){
            //ya toh vo pehle se palindrome hai, nhito reverse of the left half is smaller
            inc=true;
        }
        
        for(int i=0;i<n/2;i++){//mirroring
            num[n-1-i]=num[i];
        }        
        
        if(inc){
            int carry=1;
            int l=mid-1;
            int r=(n%2==0)?mid:mid+1;
            
            if(n%2!=0){
                num[mid]+=carry;
                carry=num[mid]/10;
                num[mid]%=10;
            }
            
            while(l>=0 && carry>0){
                num[l]+=carry;
                carry=num[l]/10;
                num[l]%=10;
                num[r]=num[l];
                l--;r++;
            }
            
        }
        
        return num;
    }
}