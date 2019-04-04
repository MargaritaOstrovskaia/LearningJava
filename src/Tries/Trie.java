package Tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trie {
    private TrieNode root;
    private int size;

    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    public boolean addWord(String word) {
        boolean isAdded = false;
        word = word.toLowerCase();

        TrieNode targetNode = root;
        char[] words =  word.toCharArray();
        for (int i=0; i<words.length; i++) {
            char ch = words[i];
            TrieNode currentNode = targetNode.getChild(ch);
            if(currentNode == null) {
                targetNode = targetNode.add(ch);

                if (i == words.length-1) {
                    targetNode.setIsWord(true);
                    size++;
                    isAdded = true;
                }
            }
            else {
                targetNode = currentNode;

                if (i == words.length-1)
                    if (!targetNode.isWord()) {
                        targetNode.setIsWord(true);
                        size++;
                        isAdded = true;
                    }
            }
        }

        return isAdded;
    }

    public int size() {
        return size;
    }

    public boolean isWord(String s) {
        s = s.toLowerCase();

        TrieNode targetNode = root;
        char[] words =  s.toCharArray();
        for (int i=0; i<words.length; i++) {
            char ch = words[i];
            targetNode = targetNode.getChild(ch);

            if(targetNode == null)
                return false;

            if(targetNode.getText().equals(s) && targetNode.isWord())
                return true;
        }

        return false;
    }

    public void printTree() {
        printNode(root);
    }

    private void printNode(TrieNode curr)
    {
        if (curr == null)
            return;

        System.out.println(curr.getText());

        TrieNode next = null;
        for (Character c : curr.getChildren()) {
            next = curr.getChild(c);
            printNode(next);
        }
    }
}
