class Solution {
    //n log n tak jaa sakte h
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFact=Integer.MIN_VALUE;
        int n=items.length;
        int minPrice=Integer.MAX_VALUE;

        for(int[] item:items){
            minPrice=Math.min(minPrice,item[1]);
            maxFact=Math.max(maxFact, item[0]);
        }

        int[] freq=new int[maxFact+1]; //kyuki factor <= n
        for(int[] item:items){
            freq[item[0]]++;
        }

        //iss particular factor se aur kitne factors divisible hai
        int[] multiple=new int[n+1];
        for(int i=1;i<=maxFact;i++){
            if(freq[i]==0) continue; 
            //agar i hi 0 h toh iske age iske multiples dekh ke bhi koi matlab nahi

            for(int j=i;j<=maxFact;j+=i){
                multiple[i]+=freq[j];
            }
        }

        //removing itself from the count and reducing the concern
        List<long[]> pack=new ArrayList<>();
        for(int[] item:items){
            int price=item[1];
            int fact=item[0];
            // D is total multiples minus 1 - khud ke sath pairing nahi karni h
            int d=multiple[fact]-1;

            if(d>0 && price<2*minPrice){
                pack.add(new long[]{price,d});
            }
        }
        //price pe sort karenge
        pack.sort((x,y)-> Long.compare(x[0],y[0]));

        long total=0;
        long curBud=budget;
        for(long[] p:pack){
            long price=p[0];
            long d=p[1];

            if(curBud<price) break;

            long buy=Math.min(d, curBud/price);
            total+=buy*2;
            curBud-=buy*price;
        }

        total+=curBud/minPrice;

        return (int)total;
    }
}