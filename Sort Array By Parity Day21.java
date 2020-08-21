/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        List<Integer> res1 = new ArrayList<>();
        
        List<Integer> res2 = new ArrayList<>();
        
        
        
        for(int i=0;i<A.length;i++) {
            if(A[i]%2==0) {
                res1.add(A[i]);
            } else {
                res2.add(A[i]);
            }
        }
        int result[] = new int[res1.size()+res2.size()];
        int i=0;
        for(Integer int1: res1) {
            result[i++]=int1;
        }
        for(Integer int2: res2) {
            result[i++]=int2;
        }
        
        return result;
        
    }
}
