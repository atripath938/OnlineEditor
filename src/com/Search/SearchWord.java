package com.Search;

import com.resources.DictionaryHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchWord")
public class SearchWord extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String word = request.getParameter("word");
        String responseString;
        boolean exists = DictionaryHandler.checkWordExists(word);
        if(exists)
            responseString="It is a valid word";
        else{

        }
    }

}
