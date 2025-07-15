class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        Map<Character, String> map=new HashMap<>(); 
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder(), map, res);
        return res;
    }

    private void backtrack(String digits, int ind, StringBuilder str, Map<Character, String> map, List<String> res){
        if(ind==digits.length()){
            res.add(str.toString());
            return;
        }

        String letters=map.get(digits.charAt(ind));
        for(char c: letters.toCharArray()){
            str.append(c);
            backtrack(digits, ind+1, str, map, res);
            str.deleteCharAt(str.length()-1);
        }
    }
}