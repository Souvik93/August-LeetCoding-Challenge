/*
Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9
*/
class Solution {
    
    List<Integer> li = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        
        if(N==0) {
            return new int[0];
        } 
        if(N==1) {
            li.add(0);
        }
        dfs(N,K,0);
        return li.stream().mapToInt(i->i).toArray();
        
    }
    
    private void dfs(int n,int k,int number) {
        
        if(n==0) {
            li.add(number);
            return;
        } 
        
        for(int i=0;i<10;i++) {
            if(i==0 && number==0) {
                continue;
            } else if (number==0 && i!=0) {
                dfs(n-1,k,i);
            } else {
                if(Math.abs((number%10)-i)==k) {
                    dfs(n-1,k,number*10+i);
                }
            }
        }
        
    }
}
