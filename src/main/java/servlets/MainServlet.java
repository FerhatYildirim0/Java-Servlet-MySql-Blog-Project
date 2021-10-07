package servlets;

import props.Blog;
import utils.DBUtil;
import utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mainServlet",value = "/main-servlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cidx=Integer.parseInt(req.getParameter("cidx"));
        req.getSession().setAttribute("updateCidx",cidx);
        DBUtil util=new DBUtil();
        Blog blog=util.singBlog(cidx);
        req.setAttribute("blog",blog);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Details.jsp");
        dispatcher.forward(req, resp);
        dispatcher.forward(req, resp);
    }




}
