class Solution {
    public double angleClock(int hour, int minutes) {
        double min=minutes*6.0;
        double add=minutes*0.5;

        double ho=(hour%12)*30+add;
        double res=Math.abs(min-ho);
        
        return Math.min(res, 360.0-res);
    }
}