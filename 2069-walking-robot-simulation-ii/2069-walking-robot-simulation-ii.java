class Robot {
    private int ind=0;
    private boolean moved=false;
    private List<Integer> dir=new ArrayList<>();
    private List<int[]> pos=new ArrayList<>();
    private Map<Integer, String> toDir=new HashMap<>();
    
    public Robot(int width, int height) {
        toDir.put(0, "East");
        toDir.put(1, "North");
        toDir.put(2, "West");
        toDir.put(3, "South");

        for(int x=0;x<width;x++){
            pos.add(new int[]{x,0});
            dir.add(0);
        }
        for(int y=1;y<height;y++){
            pos.add(new int[]{width-1,y});
            dir.add(1);
        }
        for(int x=width-2;x>=0;x--){
            pos.add(new int[]{x,height-1});
            dir.add(2);
        }
        for(int y=height-2;y>0;y--){
            pos.add(new int[]{0,y});
            dir.add(3);
        }
        dir.set(0,3);
    }
    
    public void step(int num) {
        moved=true;
        ind=(ind+num)%pos.size();
    }
    
    public int[] getPos() {
        return pos.get(ind);
    }
    
    public String getDir() {
        if(!moved){
            return "East";
        }
        return toDir.get(dir.get(ind));
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */