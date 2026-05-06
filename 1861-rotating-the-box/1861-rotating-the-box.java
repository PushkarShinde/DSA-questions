class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n=box.length;
        int m=box[0].length;
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                if(box[i][j]=='#'){
                    int stop=j;
                    for(int k=j+1;k<m;k++){
                        if(box[i][k]=='#' || box[i][k]=='*'){
                            stop=k-1;
                            break;
                        }
                        if(k==m-1) stop=k;
                    }
                    if(stop==j) continue;
                    char temp=box[i][stop];
                    box[i][stop]='#';
                    box[i][j]=temp;
                }
            }
        }

        char[][] res=new char[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[j][i]=box[i][j];
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                char temp=res[i][j];
                res[i][j]=res[i][n-1-j];
                res[i][n-1-j]=temp;
            }
        }
        return res;
    }
}