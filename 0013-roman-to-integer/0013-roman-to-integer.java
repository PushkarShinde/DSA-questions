class Solution {
    public int romanToInt(String s) {
        int num=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I') num+=1;
            else if(s.charAt(i)=='V'){
                num+=5;
                if(i!=0){ 
                    if(s.charAt(i-1)=='I') num-=2;
                }
            }
            else if(s.charAt(i)=='X'){ 
                num+=10;
                if(i!=0){ 
                    if(s.charAt(i-1)=='I') num-=2;
                    else if(s.charAt(i-1)=='V') num-=10;
                }

            }
            else if(s.charAt(i)=='L') {
                num+=50;
                if(i!=0){ 
                    if(s.charAt(i-1)=='I') num-=2;
                    else if(s.charAt(i-1)=='V') num-=10;
                    else if(s.charAt(i-1)=='X') num-=20;
                }
            }
            else if(s.charAt(i)=='C'){
                num+=100;
                if(i!=0){ 
                    if(s.charAt(i-1)=='I') num-=2;
                    else if(s.charAt(i-1)=='V') num-=10;
                    else if(s.charAt(i-1)=='X') num-=20;
                    else if(s.charAt(i-1)=='L') num-=100;
                }
            }
            else if(s.charAt(i)=='D'){
                num+=500;
                if(i!=0){ 
                    if(s.charAt(i-1)=='I') num-=2;
                    else if(s.charAt(i-1)=='V') num-=10;
                    else if(s.charAt(i-1)=='X') num-=20;
                    else if(s.charAt(i-1)=='L') num-=100;
                    else if(s.charAt(i-1)=='C') num-=200;
                }
            }
            else if(s.charAt(i)=='M'){
                num+=1000;
                if(i!=0){ 
                    if(s.charAt(i-1)=='I') num-=2;
                    else if(s.charAt(i-1)=='V') num-=10;
                    else if(s.charAt(i-1)=='X') num-=20;
                    else if(s.charAt(i-1)=='L') num-=100;
                    else if(s.charAt(i-1)=='C') num-=200;
                    else if(s.charAt(i-1)=='D') num-=500;
                }
            }
        }
        return num;
    }
}