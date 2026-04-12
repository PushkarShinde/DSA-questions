class Solution {
    public double[] internalAngles(int[] sides) {
        double a=sides[0];
        double b=sides[1];
        double c=sides[2];
        if(a+b<=c || a+c<=b || c+b<=a) return new double[]{};

        double angleA=calculate(a,b,c);
        double angleB=calculate(b,a,c);
        double angleC=calculate(c,a,b);

        double[] res={angleA, angleB, angleC};
        Arrays.sort(res);

        return res;
    }

    private double calculate(double op, double side2, double side3){
        double cos=(side2*side2 +side3*side3 -op*op)/(2*side2*side3);
        return Math.acos(cos)*180.0/Math.PI;
    }
}