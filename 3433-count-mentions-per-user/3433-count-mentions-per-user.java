class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n=events.size();
        int[] mentions=new int[numberOfUsers];
        int[] offline=new  int[numberOfUsers];
        boolean[] online=new  boolean[numberOfUsers];
        Arrays.fill(online, true);
        events.sort((a,b)->{
            int t1=Integer.parseInt(a.get(1));
            int t2=Integer.parseInt(b.get(1));
            if(t1!=t2) return t1-t2;
            if(a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")) return 1;
            if(a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")) return -1;
            return 0;
        });

        for (List<String> e : events) {
            String message=e.get(0);
            int time=Integer.parseInt(e.get(1));
            String ment=e.get(2);
            for(int j=0;j<numberOfUsers;j++){
                if(!online[j] && time>=(offline[j]+60)) online[j]=true;
            }
            if(message.equals("MESSAGE")){
                if(ment.equals("ALL")){
                    for(int j=0;j<numberOfUsers;j++){
                        mentions[j]++;
                    }
                }else if(ment.equals("HERE")){
                    for(int j=0;j<numberOfUsers;j++){
                        if(online[j]) mentions[j]++;
                    }
                }else{
                    String[] ids=ment.split(" ");
                    for(String id:ids){
                        int user=Integer.parseInt(id.substring(2));
                        mentions[user]++;
                    }
                }
            }else{
            // String[] users=ment.split(" ");
            // for(int j=0;j<users.length;j++){
                int user=Integer.parseInt(ment);
                offline[user]=time;
                online[user]=false;
            // }
            }
        }
        return mentions;
    }
}