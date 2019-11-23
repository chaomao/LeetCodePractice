//https://leetcode-cn.com/problems/implement-trie-prefix-tree/submissions/
class Trie {
    private TrieNode root;

    private final int CharCount = 26;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }
}


class TrieNode {

    private TrieNode[] links;

    private final int CharCount = 26;

    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[CharCount];
        this.isEnd = false;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}