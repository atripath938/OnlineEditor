package com.Search;

import com.resources.DictionaryHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchWord")
public class SearchWord extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String word = request.getParameter("partialWord");
        String responseString;
        boolean exists = DictionaryHandler.checkWordExists(word);
        if (exists)
            responseString = "It is a valid word";
        else
            responseString = "It is not a valid word";

        response.setStatus(200);
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(responseString);

    }

}
