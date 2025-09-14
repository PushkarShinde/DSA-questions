class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();
        for (String w : wordlist) {
            exact.add(w);
            String lower = w.toLowerCase();
            caseInsensitive.putIfAbsent(lower, w);
            String masked = maskVowels(lower);
            vowelInsensitive.putIfAbsent(masked, w);
        }
        int qu=queries.length;
        String[] res=new String[qu];
        for(int i=0;i<qu;i++){
            String q=queries[i];
            if(exact.contains(q)){
                res[i]=q; // exact match mil gaya
            }else{
                String lower=q.toLowerCase();
                if(caseInsensitive.containsKey(lower)){
                    res[i]=caseInsensitive.get(lower);
                }else {
                    String masked = maskVowels(lower);
                    res[i] = vowelInsensitive.getOrDefault(masked, "");
                }
            }
        }
        return res;
    }
    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }
    private boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}