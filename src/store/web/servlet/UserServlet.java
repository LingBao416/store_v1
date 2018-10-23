package store.web.servlet;

import store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    public String registUI(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return  "/jsp/register.jsp";
    }
}
