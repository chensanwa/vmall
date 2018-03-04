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

@WebServlet(name = "RegisterByEmailServlet")
public class RegisterByEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = "";      //邮箱
        String graphicVerification = "";    //用户输入图像验证码
        String emailVerification = "";      //用户邮箱验证码
        String password = "";       //密码
        String confirmPassword = "";    //确认密码
        String telphone = "";       //电话
        String messageVerification = "";        //用户输入短信验证码

        String pictureCode = "";    //系统图像验证码

        CustomerAction customerAction = new CustomerAction();
        Customer customer = new Customer();

        //获得前端数据
        if(request.getParameter("email") != null){
            email = request.getParameter("email").toString().trim();
        }
        if (request.getParameter("graphic-verfication") != null) {
            graphicVerification = request.getParameter("graphic-verfication").toString().trim();
        }
        if(request.getParameter("email-verification") != null){
            emailVerification = request.getParameter("email-verification").toString().trim();
        }
        if (request.getParameter("password") != null) {
            password = request.getParameter("password").toString().trim();
        }
        if (request.getParameter("confirm-password") != null) {
            confirmPassword = request.getParameter("confirm-password").toString().trim();
        }
        if (request.getParameter("telphone") != null) {
            telphone = request.getParameter("telphone").toString().trim();
        }
        if (request.getParameter("message-verification") != null) {
            messageVerification = request.getParameter("message-verification").toString().trim();
        }

        //用正则表达式验证用户输入的邮箱字符串是否合法
        if(Regex.checkEmail(email)){
            customer.setEmail(email);

        } else {

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

        //此处验证邮件验证码

        //判断密码和确认密码是否一致
        if (password.equals(confirmPassword)) {
            //用户密码和确认密码一致
            customer.setPassword(password);

        } else {
            //密码不一致

        }

        //利用正则表达式判断用户输入的电话字符串是否合法
        if(Regex.checkPhoneNumber(telphone)){
            //表示用户输入的电话字符串是合法11位数字字符串
            customer.setTelphone(telphone);
            customer.setName(telphone);     //默认用户名为手机号

        } else {
            //用户输入的字符串非数字字符串或者非11位

        }


        //此处用于验证短信验证码

//        System.out.println("Email:"+email);
//        System.out.println("Password:"+password);
//        System.out.println("confirm-password:"+confirmPassword);
//        System.out.println("Telphone:"+telphone);
//        customer.setEmail(email);
//        customer.setPassword(password);
//        customer.setTelphone(telphone);
//        customer.setName(email);
//        System.out.println(customer);

        //注册用户
        customerAction.registerByEmail(customer);
        response.sendRedirect("/html/login.html");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
