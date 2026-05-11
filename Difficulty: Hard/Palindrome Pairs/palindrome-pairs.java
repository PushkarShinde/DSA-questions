class Solution {
    public boolean palindromePair(String[] arr) {
        int n=arr.length;
        if(n<2) return false;
        
        Map<String, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i], i);
        }
        
        for(int i=0;i<n;i++){
            String word=arr[i];
            int len=word.length();
            
            for(int cut=0;cut<=len;cut++){
                String pre=word.substring(0,cut);
                String suf=word.substring(cut);
                
                // CASE 1:
                // prefix palindrome
                // reverse(suffix) + word
                if(palindrome(pre)){
                    String revSuf=new StringBuilder(suf).reverse().toString();
                    
                    Integer ind=map.get(revSuf);
                    if(ind!=null && ind!=i){
                        return true;                    
                    }
                }
                
                // CASE 2:
                // suffix palindrome
                // word + reverse(prefix)

                // IMPORTANT:
                // cut != word.length()
                // avoids duplicate processing
                if(cut!=len && palindrome(suf)){
                    String revPre=new StringBuilder(pre).reverse().toString();
                    Integer ind=map.get(revPre);
                    if(ind!=null && ind!=i){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean palindrome(String pal){
        int n=pal.length();
        for(int i=0;i<n/2;i++){
            if(pal.charAt(i)!=pal.charAt(n-1-i)) return false;
        }
        return true;
    }
}