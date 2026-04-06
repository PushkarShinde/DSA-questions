class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n=commands.length;
        int m=obstacles.length;

        Set<String> obs=new HashSet<>();
        for(int[] k:obstacles){
            String key=""+k[0]+","+k[1];
            obs.add(key);
        }

        int x=0;
        int y=0;
        int maxDist=0;

        int[] dir={0,1};//north

        for(int i=0;i<n;i++){
            int com=commands[i];
            if(com==-2){//turn left
                dir=new int[]{-1*dir[1],dir[0]};
            }else if(com==-1){
                dir=new int[]{dir[1],-1*dir[0]};
            }else{
                for(int step=0;step<com;step++){
                    int nx=x+dir[0];
                    int ny=y+dir[1];
                    String key=""+nx+","+ny;
                    if(obs.contains(key)){
                        break;
                    }
                    x=nx;
                    y=ny;
                }
            }
            maxDist=Math.max(maxDist, x*x+y*y);
        }
        return maxDist;
    }
}