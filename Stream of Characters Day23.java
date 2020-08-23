/*

Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.
   Hide Hint #1  
Put the words into a trie, and manage a set of pointers within that trie.

*/

class StreamChecker {
    
    Trie root;
    
    StringBuilder sb;

    public StreamChecker(String[] words) {
        
        this.root = new Trie();
        this.sb = new StringBuilder();
        
        for(String str: words) {
            insert(str);
        }
        
        
    }
    
    private void insert(String word) {
        
        Trie curr = root;
        
        for(int i=word.length()-1;i>=0;i--) {
            
            char c = word.charAt(i);
            
            Trie next = curr.child[c-'a'];
            
            if(next==null) {
                next = new Trie();
                curr.child[c-'a'] = next;
            }
            
            curr = curr.child[c-'a'];
            
        }
        
        curr.eow = true;
        
    }
    
    public boolean query(char letter) {
        
        sb.append(letter);
        
        Trie curr = root;
        
        for(int i=sb.length()-1;i>=0;i--) {
            
            if(curr.child[sb.charAt(i)-'a']==null) {
                return false;
            }
            
            curr = curr.child[sb.charAt(i)-'a'];
            
            if(curr.eow) {
                return true;
            }
            
            
        }
        
        return false;
        
    }
}

class Trie {
    
    boolean eow;
    Trie child[];
    
    Trie() {
        this.eow = false;
        child = new Trie[26]; 
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
