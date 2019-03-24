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

    public static String checkWordExists(String word) {

        String returnString = "";
        StringBuilder currentWord;
        if (wordSetBuilt) {

            String[] allWords = word.split(" ");
            WordNode node = rootNode;
            char charInFocus;

            for (int wordNumber = 0; wordNumber < allWords.length; wordNumber++) {
                node = rootNode;
                currentWord = new StringBuilder();
                for (int i = 0; i < allWords[wordNumber].length(); i++) {
                    charInFocus = allWords[wordNumber].toLowerCase().charAt(i);
                    if (charInFocus != '\n') {
                        if (node.NodeList[charInFocus - 'a'] != null) {
                            node = node.NodeList[charInFocus - 'a'];
                            currentWord.append(allWords[wordNumber].charAt(i));
                        } else {
                            returnString += "<span class=\"redFont\">" + allWords[wordNumber] + "</span> ";
                            break;
                        }
                    }
                    if (i == allWords[wordNumber].length() - 1)
                        returnString += currentWord + " ";
                }
            }

        }

        if (word.charAt(word.length() - 1) == ' ')
            return returnString;
        else
            return returnString.substring(0, returnString.length() - 1);
    }

}
