class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len=encodedText.length();
        int m=(len+rows-1)/rows;
        int n=rows;
        char[][] grid=new char[n][m];
        int ind=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ind<len)
                grid[i][j]=encodedText.charAt(ind++);
            }
        }

        StringBuilder res=new StringBuilder();
        for(int j=0;j<m;j++){
            int x=0, y=j;
            while(x<n && y<m){
                res.append(grid[x][y]);
                x++; y++;
            }
        }

        int end=res.length()-1;
        while(end>=0 && res.charAt(end)==' '){
            end--;
        }

        return res.toString().substring(0,end+1);
    }
}