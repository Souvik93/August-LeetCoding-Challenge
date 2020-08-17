/*

We distribute some number of candies, to a row of n = num_people people in the following way:

We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.

Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.

This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).

Return an array (of length num_people and sum candies) that represents the final distribution of candies.

 

Example 1:

Input: candies = 7, num_people = 4
Output: [1,2,3,1]
Explanation:
On the first turn, ans[0] += 1, and the array is [1,0,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0,0].
On the third turn, ans[2] += 3, and the array is [1,2,3,0].
On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
Example 2:

Input: candies = 10, num_people = 3
Output: [5,2,3]
Explanation: 
On the first turn, ans[0] += 1, and the array is [1,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0].
On the third turn, ans[2] += 3, and the array is [1,2,3].
On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 

Constraints:

1 <= candies <= 10^9
1 <= num_people <= 1000
   Hide Hint #1  
Give candy to everyone each "turn" first [until you can't], then give candy to one person per turn.

*/

class Solution {
    
    
    
    
    public int[] distributeCandies(int candies, int num_people) {
        
       /* int arr[] = new int[num_people];
        
        int n=0;
        
        while(candies !=0) {
            
            for(int i=0;i<arr.length;i++) {
                
                System.out.println("Hey There !! From For Loop"+candies);
                
                if(arr[i]==0) {
                    
                    if(candies>i+1) {
                        arr[i] = arr[i] + i+1;
                        candies = candies-(i+1);
                    } else {
                        arr[i]=arr[i]+candies;
                        candies=0;
                        break;
                    }
                    
                    
                } else {
                    n++;
                    if(candies>num_people+i+1+n) {
                        arr[i]=arr[i]+num_people+i+1+n;
                        candies= candies - (num_people+i+1+n);
                    } else {
                        arr[i] = arr[i]+candies;
                        candies = 0;
                        break;
                    }
                }
                
                
                               
            }
            
            System.out.println("Hey There !! From While Loop"+candies);
            
            
            
        }
        return arr; */
        
         int arr[] = new int[num_people];
        
        
        for(int index=0;candies>0;index++) {
            
            
            arr[index%num_people] += Math.min(index+1,candies);
            
            candies = candies-(index+1);
            
            
        }
        
        return arr;
        
}
}
