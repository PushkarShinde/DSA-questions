class Solution {
    public String decodeString(String s){
        Stack<Integer> numStack = new Stack<>();  // Stack to store repeat count
        Stack<String> strStack = new Stack<>();   // Stack to store previous substrings
        String currStr = "";
        int currNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');  // Handle multi-digit numbers
            } else if (c == '[') {
                numStack.push(currNum);  // Store the repeat count
                strStack.push(currStr);  // Store the current string before new segment
                currStr = "";
                currNum = 0;
            } else if (c == ']') {
                int repeat = numStack.pop();  // Get the repeat count
                String temp = currStr.repeat(repeat);  // Repeat the string `repeat` times
                currStr = strStack.pop() + temp;  // Append to previous string
            } else {
                currStr += c;  // Append normal characters
            }
        }
        return currStr;
    }
}