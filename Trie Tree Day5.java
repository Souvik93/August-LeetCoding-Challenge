class WordDictionary {

    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure.*/
    public void addWord(String word) {
        TrieNode node = root;
        
        for(int c=0;c<word.length();i++) {
            int j = word.charAt(i)-'a';
            // Check Node Exists Or Not 
            
            if(node.children[j]==null) {
                node.children[j]=new TrieNode();
            }
            
            node = node.children[i];
            
            }
        
        node.isWord = false;
        node.word = word;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        return findAll(word,0,root);
        
    }
    
    
    
    private boolean findAll(String word,int index, TrieNode node) {
        
        if(index==word.length) {
            return word.isWord;
        }
        
        if(word.charAt(i)=='.') {
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
    TrieNode[] childs;
    String word;
    
    TrieNode() {
        this.isWord = false;
        this.word = "";
        this.childs = new TrieNode[26];
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
