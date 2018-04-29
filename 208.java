class Trie {
    TrieNode head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null)
            return;
        char[] toInsert = word.toCharArray();

        TrieNode node = head;
        for (char c : toInsert) {
            if (node.charToNode.containsKey(c)) {
                node = node.charToNode.get(c);
            } else {
                TrieNode temp = new TrieNode();
                node.charToNode.put(c, temp);
                node = temp;
            }
        }
        node.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null)
            return false;
        char[] toSearch = word.toCharArray();
        TrieNode node = head;
        for (char c : toSearch) {
            if (!node.charToNode.containsKey(c))
                return false;
            node = node.charToNode.get(c);
        }
        return node.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null)
            return false;
        char[] toSearch = prefix.toCharArray();
        TrieNode node = head;
        for (char c : toSearch) {
            if (!node.charToNode.containsKey(c))
                return false;
            node = node.charToNode.get(c);

        }
        return true;
    }

    class TrieNode {
        Map<Character, TrieNode> charToNode;
        boolean isEnd = false;

        public TrieNode() {
            charToNode = new HashMap();
        }

    }
}