package store.web.servlet;

import store.domain.Category;
import store.service.CategoryService;
import store.service.impl.CategoryServiceImpl;
import store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务层功能
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCategory = null;
        try {
            allCategory = categoryService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("allCategory",allCategory);

        //转发到真实的首页
        return "/jsp/index.jsp";
    }
}
