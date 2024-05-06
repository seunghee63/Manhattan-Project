// Runtime 375ms Beats 5.03% of users with Java
// Memory 55.58MB Beats 24.41% of users with Java

class Node {
    Map<Character, Node> children;
    Character content;
    boolean word;

    public Node() {
        children = new HashMap<>();
    }

    public Node(Character content, boolean word) {
        children = new HashMap<>();
        this.content = content;
        this.word = word;
    }
}
class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.toCharArray()[i])) {
                cur.children.put(word.toCharArray()[i], new Node(word.toCharArray()[i], i == word.length() - 1));
            }
            if (i == word.length() -1) {
                Node node = cur.children.get(word.toCharArray()[i]);
                node.word = true;
            }
            cur = cur.children.get(word.toCharArray()[i]);
        }
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children.containsKey(word.toCharArray()[i])) {
                cur = cur.children.get(word.toCharArray()[i]);
            } else {
                return false;
            }
        }

        return cur.word;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children.containsKey(prefix.toCharArray()[i])) {
                cur = cur.children.get(prefix.toCharArray()[i]);
            } else {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
