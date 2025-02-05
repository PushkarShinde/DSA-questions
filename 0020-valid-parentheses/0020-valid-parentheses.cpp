class Solution {
public:
    bool isValid(string s) {
        // 40	(	Left parenthesis
        // 41	)	Right parenthesis
        // 91	[	Left square bracket
        // 93	]	Right square bracket
        // 123	{	Left curly brace
        // 125	}	Right curly brace
        int lp=0, rp=0, lsb=0, rsb=0, lcb=0, rcb=0;
        for(char c:s){
            if(c=='(') lp++;
            if(c==')') rp++;
            if(c=='[') lsb++;
            if(c==']') rsb++;
            if(c=='{') lcb++;
            if(c=='}') rcb++;
        }
        if(lp==rp && lsb==rsb && lcb==rcb) return true;
        return false;
    }
};