package com.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryHandler {

    private static WordNode rootNode = new WordNode();
    private static boolean wordSetBuilt = false;

    static WordNode getRootNode() {
        return rootNode;
    }

    public static void createWordList() {

        if (!wordSetBuilt) {
            File wordFile = new File("/home/anurag/WordSearchApp/words.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(wordFile))) {

                String currentWord = reader.readLine();
                WordNode currentNode;

                while (currentWord != null) {
                    currentNode = getRootNode();
                    for (int i = 0; i < currentWord.length(); i++) {
                        if (currentNode.NodeList[currentWord.charAt(i) - 'a'] == null)
                            currentNode.NodeList[currentWord.charAt(i) - 'a'] = new WordNode();
                        currentNode = currentNode.NodeList[currentWord.charAt(i) - 'a'];
                    }
                    currentNode.setEnd(true);
                    currentWord = reader.readLine();
                }

            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean checkWordExists(String word) {

        if (wordSetBuilt) {

            WordNode node = rootNode;

            for (int i = 0; i < word.length(); i++) {
                if (node.NodeList[word.charAt(i) - 'a'] != null)
                    node = node.NodeList[word.charAt(i) - 'a'];
                else
                    return false;
            }

            return node.isEnd();

        }

        return false;
    }

    public static void main(String[] args) {
        createWordList();
    }

}
