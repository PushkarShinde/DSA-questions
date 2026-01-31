class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
      int n=letters.length;
      Set<Character> set=new TreeSet<>();
      for(int i=0;i<n;i++){
        if(letters[i]>target)set.add(letters[i]);
      }
      if(set.size()==0) return letters[0];
      char smallest='z';
      for(char c:set){
        if(c<smallest){
          smallest=c;
        }
      }
      return smallest;
    }
}