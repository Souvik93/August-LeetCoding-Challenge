/*

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?

*/


class Solution {
    public boolean isPowerOfFour(int num) {
        
     /*   int counter = 0;
        
    for(int i=0;i<32;i++) {
        if(((num>>>i)&1)==1) {
            counter++;
            
            if(i%2==1) {
                return false;
            }
            
        }
    }
        
        return counter==1; */
        
        
        if(((num-1)&num)!=0) {
            
            return false;
            
        }
        
        if((num & 1431655765) !=0) {
            return true;
        } else {
            return false;
        }
        
    }
}
