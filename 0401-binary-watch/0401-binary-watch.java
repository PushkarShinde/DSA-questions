class Solution {
    public List<String> readBinaryWatch(int to) {
        List<String> res=new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==to){
                    StringBuilder sb=new StringBuilder();
                    sb.append(h).append(":").append((m<10)?("0"+m):m);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}