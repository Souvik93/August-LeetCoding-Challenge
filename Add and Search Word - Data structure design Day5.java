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

    /** Initialize your data structure here. */
    
    
    private Map<Integer,List<String>>  map;
    public WordDictionary() {
        
        map = new HashMap<>();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        if(map.containsKey(word.length())) {
            
            map.get(word.length()).add(word);
            
        } else {
            List<String> l = new ArrayList<>();
            l.add(word);
            map.put(word.length(),l);
        }
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        if(map.containsKey(word.length())) {
            
            List<String> wd = map.get(word.length());
            
            for(String str: wd) {
                
                if(compareWords(word,str)) {
                    return true;
                }
                
                
            }
            return false;
            
            
        } else {
            return false;
        }
        
    }
           

           private boolean compareWords(String word,String str) {
               
               
               for(int c=0;c<word.length();c++) {
                   
                   if(word.charAt(c)=='.') {
                       continue;
                   } 
                   
                   if(word.charAt(c) != str.charAt(c)) {
                       return false;
                   }
                   
               }
               
               return true;
               
               
           }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
