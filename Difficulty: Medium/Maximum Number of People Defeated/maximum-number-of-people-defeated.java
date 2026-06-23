class Solution {
    int maxPeopleDefeated(int p) {
        int i=1;
        while(i*i<=p){
            p-=(i*i);
            i++;
        }
        return i-1;
    }
};