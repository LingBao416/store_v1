package store.web.servlet;

import com.mysql.cj.xdevapi.JsonArray;
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

public class CategoryServlet extends BaseServlet {
    public String findAllCats(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //获取所有分类
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCategory = categoryService.findAll();
        //查询结果转换为json

        //结果相应到浏览器
        return null;
    }
}
