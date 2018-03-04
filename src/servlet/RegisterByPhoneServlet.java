package servlet;

import action.CustomerAction;
import model.Customer;
import util.Regex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterByPhoneServlet")
public class RegisterByPhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String telphone = "";   //电话号码
        String graphicVerification = "";    //用户输入的图形验证码
        String messageVerification = "";     //短信验证码
        String password = "";   //密码
        String confirmPassword = "";    //确认密码

        String pictureCode = "";    //图形验证码     Session对象获得

        CustomerAction customerAction = new CustomerAction();
        Customer customer = new Customer();

        //获得前端数据
        if (request.getParameter("telphone") != null) {
            telphone = request.getParameter("telphone").toString().trim();
        }
        if (request.getParameter("graphic-verification") != null) {
            graphicVerification = request.getParameter("graphic-verification").toString().trim();
        }
        if (request.getParameter("message-verification") != null) {
            messageVerification = request.getParameter("message-verification").toString().trim();
        }

        if (request.getParameter("password") != null) {
            password = request.getParameter("password").toString().trim();
        }
        if (request.getParameter("confirm-password") != null) {
            confirmPassword = request.getParameter("confirm-password").toString().trim();
        }

        //利用正则表达式判断用户输入的电话字符串是否合法
        if(Regex.checkPhoneNumber(telphone)){
            //表示用户输入的电话字符串是合法11位数字字符串
            customer.setTelphone(telphone);
            customer.setName(telphone);     //默认用户名为手机号

        } else {
            //用户输入的字符串非数字字符串或者非11位

        }

        //获取Session对象
        HttpSession session = request.getSession();
        //获取正确图形验证码
        pictureCode = session.getAttribute("piccode").toString().trim();
        if (graphicVerification.equals(pictureCode)) {
            //图形验证码输入正确

        } else {
            //图形验证码输入错误

        }

        //此处用于验证短信验证码

        //判断密码和确认密码是否一致
        if (password.equals(confirmPassword)) {
            //用户密码和确认密码一致
            customer.setPassword(password);

        } else {
            //密码不一致

        }

        //注册用户
        customerAction.registerByPhone(customer);
        response.sendRedirect("/html/login.html");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
