/*

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

   Hide Hint #1  
You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.

*/


class WordDictionary {

    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure.*/
    public void addWord(String word) {
        
     TrieNode tNode = root;
    
        for(int c=0;c<word.length();c++) {
            
            int k = word.charAt(c)-'a';
            
            if(tNode.children[k]==null) {
                tNode.children[k] = new TrieNode();
            }
            tNode = tNode.children[k];
            
            
        }
        
        tNode.word = word;
        tNode.isWord = true;
    
    
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        return findAll(word,0,root);
        
    }
    
    
    
    private boolean findAll(String word,int index, TrieNode node) {
        
        if(index==word.length()) {
            return node.isWord;
        }
        
        if(word.charAt(index)=='.') {
            for(TrieNode c: node.children) {
                if(c!=null && findAll(word,index+1,c)) {
                    return true;
                }
            }
            return false;
        } else{
            int j = word.charAt(index)-'a';
            TrieNode t =node.children[j];
            return(t!=null && findAll(word,index+1,t));
        }
        
        
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    String word;
    
    TrieNode() {
        this.isWord = false;
        this.word = "";
        this.children = new TrieNode[26];
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
