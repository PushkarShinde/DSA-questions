class Solution {
public:
    string compare(string a, string b){
        int n=a.length(), m=b.length();
        string str;
        for(int i=0;i<min(n,m);i++){
            if(a[i]==b[i]){
                str+=a[i];
            } else break;
        }
        return str;
    }
    string longestCommonPrefix(vector<string>& strs) {
        int n=strs.size();
        if(strs.empty()) return "";
        string s=strs[0];
        for(int i=1;i<n;i++){
            s=compare(strs[i],s);
            if(s.empty()) break;
        }
        return s;
    }
};