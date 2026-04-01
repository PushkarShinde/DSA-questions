class Solution {
    class Robot{
        int pos;
        int health;
        char dir;
        int ind;

        Robot(int pos, int health, char dir, int ind){
            this.pos=pos;
            this.health=health;
            this.dir=dir;
            this.ind=ind;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        List<Robot> robots=new ArrayList<>();
        for(int i=0;i<n;i++){
            int pos=positions[i];
            robots.add(new Robot(pos, healths[i], directions.charAt(i), i));
        }
        Collections.sort(robots, (x,y)->x.pos-y.pos);

        Stack<Robot> stack=new Stack<>();

        for(Robot cur: robots){
            if(cur.dir=='R'){
                stack.push(cur);
            }else{
                while(!stack.isEmpty() && stack.peek().dir=='R'){
                    Robot top=stack.peek();

                    if(top.health>cur.health){
                        top.health--;
                        cur.health=0;
                        break;
                    }else if(top.health<cur.health){
                        cur.health--;
                        stack.pop();
                    }else{
                        cur.health=0;
                        stack.pop();
                        break;
                    }
                }
                if(cur.health>0){
                    stack.push(cur);
                }
            }
        }
        Collections.sort(stack, (a,b)->a.ind-b.ind);

        List<Integer> res=new ArrayList<>();
        for(Robot r:stack){
            res.add(r.health);
        }

        return res;
    }
}