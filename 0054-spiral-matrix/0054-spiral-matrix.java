class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // There's only one solution for this question and thus if this comes in your interview, mmake sure you write a clean code.
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0, bottom=n-1, left=0, right=m-1;
        List<Integer> res=new ArrayList<>();
        while(top<=bottom && right>=left){
            // adding the top row
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            // adding the right column
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                // adding the bottom row
                for(int i=right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                // adding the left column
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}

// Wow!! How beautiful na!