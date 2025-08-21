class Solution {
    public boolean checkValidString(String s) {
        int minOpen=0, maxOpen=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                minOpen++;
                maxOpen++;
            }else if(c==')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }
            if(maxOpen<0) return false;
            if(minOpen<0) minOpen=0;
        }
        return minOpen==0;
    }
}
/**
Example Walkthrough: "(*))"
Start: minOpen=0, maxOpen=0
'(' → min=1, max=1
'*' → min=0, max=2
')' → min=-1→0, max=1
')' → min=-1→0, max=0
End: minOpen=0 → ✅ valid
 */