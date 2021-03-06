/*

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Code Walkthrough:- https://youtu.be/DkqgzzoMp8A .
class Solution 
    
    int counter = 0;
    L`
    public int pathSum(TreeNode root, int sum) {
        
        calculateSum(root,sum);
        return counter;
        
    }
    
    private void calculateSum(TreeNode node,int sum) {
        
        if(node==null) {
            return;
        }
        
        li.add(node.val);
        
         calculateSum(node.left,sum);
         calculateSum(node.right,sum);
        
        int tempSum = 0;
        
        for(int l= li.size()-1;l>=0;l--) {
            
            tempSum = tempSum + li.get(l);
            
            if(tempSum==sum) {
                counter++;
            }
            
    
        }
        
        li.remove(li.size()-1);
        
    }
}
