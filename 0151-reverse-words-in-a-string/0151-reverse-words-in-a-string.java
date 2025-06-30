class Solution {
    public String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        //trim() removes leading and trailing whitespace.
        //split("\\s+") splits on one or more spaces.
        StringBuilder str=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            str.append(words[i]);
            if(i!=0) str.append(" ");
        }
        return str.toString();
    }
}
/**
\U0001f539 "\\s+" is a Regular Expression (Regex) used to split strings based on whitespace.
\U0001f4d8 In detail:
\\s → This is a regex token for any whitespace character, including:

spaces (' ')

tabs (\t)

newlines (\n)

+ → This means "one or more" of the previous token.

\U0001f50d So "\\s+" matches:
One or more whitespace characters in a row.

\U0001f538 Why double backslash (\\)?
In Java strings, a single backslash (\) is an escape character. So to pass a real backslash to the regex engine, you need to write it as \\.

"\\s+" in Java becomes \s+ in the actual regex.
*/