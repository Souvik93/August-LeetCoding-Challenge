/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        
        int arr[] = new int[59];
        
        for(char c: s.toCharArray()) {
            int index = c-'A';
            arr[index]++;
        }
        //ccc
        int length=0;
        boolean isSingle = false;
        for(int i:arr) {
            if(i%2==0) {
                length = length+i;
            } else {
                length = length+i-1;
                isSingle = true;
            }
        }
        
        return isSingle ? length+1:length; 
        
    }
}
