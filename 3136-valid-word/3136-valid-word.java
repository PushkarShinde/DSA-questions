class Solution {
    public boolean isValid(String word) {
        int n=word.length();
        if(n<3) return false;
        boolean isAlphanumeric=word.matches("[a-zA-Z0-9]+");
        boolean oneVovel=word.matches(".*[aeiouAEIOU].*");
        boolean hasConsonant = word.matches(".*[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z].*");
        return isAlphanumeric && oneVovel && hasConsonant;
    }
}

/**
Using Regular Expression (Regex)
String str = "abc123";
boolean isAlphanumeric = str.matches("[a-zA-Z0-9]+");
System.out.println(isAlphanumeric); // true
This checks if the string only contains letters (a-z, A-Z) and digits (0-9) and is non-empty.

If you want to allow underscores (_) too:
boolean isValid = str.matches("[a-zA-Z0-9_]+");

--------------------------------------------------------------
boolean oneVowel = word.matches(".*[aeiouAEIOU].*");
This checks if the string contains at least one vowel (case-insensitive if you include uppercase vowels).
 */