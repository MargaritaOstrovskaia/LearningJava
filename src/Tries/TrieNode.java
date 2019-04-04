package Tries;

import java.util.HashMap;
import java.util.Set;

public class TrieNode {
    private boolean isWord;
    private String text;
    private HashMap<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        text = "";
        isWord = false;
    }

    public TrieNode(String text) {
        this();
        this.text = text;
    }

    public TrieNode add(Character c) {
        if (children.containsKey(c)) {
            return null;
        }

        TrieNode next = new TrieNode(text + c.toString());
        children.put(c, next);
        return next;
    }

    public void setIsWord(boolean b) {
        isWord = b;
    }

    public boolean isWord() {
        return isWord;
    }

    public TrieNode getChild(Character c) {
        return children.get(c);
    }

    public Set<Character> getChildren() {
        return children.keySet();
    }

    public String getText() {
        return text;
    }
}
