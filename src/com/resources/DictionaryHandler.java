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
            //File wordFile = new File("/home/anurag/WordSearchApp/words.txt");
            File wordFile = new File(System.getProperty("user.dir") + "/words.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(wordFile))) {

                String currentWord = reader.readLine();
                WordNode currentNode;

                while (currentWord != null) {
                    if (currentWord.equals("very"))
                        System.out.println("Pausing here...");
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

            wordSetBuilt = true;

        }

    }

    public static boolean checkWordExists(String word) {

        if (wordSetBuilt) {

            String[] allWords = word.split(" ");
            WordNode node = rootNode;

            for (int wordNumber = 0; wordNumber < allWords.length; wordNumber++) {
                node = rootNode;
                for (int i = 0; i < allWords[wordNumber].length(); i++) {
                    if (node.NodeList[allWords[wordNumber].charAt(i) - 'a'] != null)
                        node = node.NodeList[allWords[wordNumber].charAt(i) - 'a'];
                    else
                        return false;
                }
            }

            return node.isEnd();

        }

        return false;
    }

}
