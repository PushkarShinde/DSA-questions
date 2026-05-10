class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        int[][] diff = new int[n][2];
        for (int i = 0; i < n; i++) {
            diff[i][0] = Math.abs(a[i] - b[i]);
            diff[i][1] = i;
        }
        
        Arrays.sort(diff, (c, d) -> Integer.compare(d[0], c[0]));
        
        int ans = 0;
        int i = 0;

        // While x and y are greater than 0, pick
        // the task with greater profit.
        while (i < n && x > 0 && y > 0) {
            int index = diff[i][1];

            if (a[index] >= b[index]) {
                ans += a[index];
                x--;
            }
            else {
                ans += b[index];
                y--;
            }
            i++;
        }
        
        // If machine B has already done maximum tasks,
        // rest of the tasks will be done by machine A.
        while (i < n && x > 0) {
            int index = diff[i][1];
            ans += a[index];
            x--;
            i++;
        }

        // If machine A has already done maximum tasks,
        // rest of the tasks will be done by machine B.
        while (i < n && y > 0) {
            int index = diff[i][1];
            ans += b[index];
            y--;
            i++;
        }

        return ans;
    }
}
