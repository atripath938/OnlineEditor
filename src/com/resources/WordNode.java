package com.resources;

public class WordNode {

    WordNode[] NodeList;
    boolean end;

    public WordNode() {
        NodeList = new WordNode[26];
        end = false;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
