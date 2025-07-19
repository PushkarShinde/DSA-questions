class Solution {
    public int minBitFlips(int start, int goal) {
        int steps=0;
        int pt=1;
        while(start!=goal){
            if((goal&pt)!=0){ //(goal) bit is set
                if((start&pt)==0){//(start) bit is not set
                    steps++;
                    start|=pt;
                }
            }else{//(goal) bit is not set
                if((start&pt)!=0){//(start) bit is set
                    steps++;
                    start^=pt;
                }
            }
            pt<<=1;
        }
        return steps;
    }
}