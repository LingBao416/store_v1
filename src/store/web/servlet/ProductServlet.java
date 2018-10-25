package store.web.servlet;

import store.domain.Product;
import store.service.ProductService;
import store.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    public String findById (HttpServletRequest request,HttpServletResponse response){
        String pid = request.getParameter("pid");
        ProductService productService = new ProductServiceImpl();
        Product product = null;
        try {
            product = productService.findById(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("product",product);
        return "/jsp/product_info.jsp";
    }
}
