/*

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False
 

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

*/

class Solution {
    public boolean detectCapitalUse(String word) {
        
        int counter = -1;
        
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            
            if(c>='A' && c<='Z') {
                if(counter+1==i) {
                    counter++;
                } else {
                    return false;
                }
            }
        }
        
        if(counter==-1 || counter==0 || counter == word.length()-1) {
            return true;
        }
        
        return false;
        
    }
}
