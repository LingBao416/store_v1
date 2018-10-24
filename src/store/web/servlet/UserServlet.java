package store.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import store.domain.User;
import store.service.UserService;
import store.service.impl.UserServiceImpl;
import store.utils.MyBeanUtils;
import store.utils.UUIDUtils;
import store.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UserServlet extends BaseServlet {

    public String registUI(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return  "/jsp/register.jsp";
    }
    public String loginUI(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return  "/jsp/login.jsp";
    }

    public String userRegist(HttpServletRequest request,HttpServletResponse response) throws  Exception{
//        接受表单参数
        Map<String,String[]> map = request.getParameterMap();
        User user = new User();
        MyBeanUtils.populate(user,map);
        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setCode(UUIDUtils.getCode());
        System.out.println(user);

        UserService userService = new UserServiceImpl();
        try {
            userService.userRegist(user);
            request.setAttribute("msg","用户注册成功，请激活");
        } catch (Exception e) {
            request.setAttribute("msg","用户注册失败，请重新注册");
        }
//        注册成功，向邮箱发送信息，跳转到提示页面
//        注册失败，跳转
        return "/jsp/info.jsp";
    }

    public String userLogin(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //获取用户数据
        User user = new User();
        MyBeanUtils.populate(user,request.getParameterMap());
        //调用业务层登录功能
        UserService userService = new UserServiceImpl();
        User user02 = null;
        try {
            user02 = userService.userLogin(user);
            //用户信息放入session
             request.getSession().setAttribute("loginUser",user02);
             response.sendRedirect("/store_v1/index.jsp");
             return null;
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            request.setAttribute("msg",msg);
            return "/jsp/login.jsp";
        }
    }

}
