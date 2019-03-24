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
        String checkedString = DictionaryHandler.checkWordExists(word);
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain;charset=UTF-8");
        if (checkedString != null) {
            response.setStatus(200);
            out.println(checkedString);
        } else {
            response.setStatus(200);
            out.println("Invalid response!!!");
        }

    }

}
