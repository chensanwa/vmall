package servlet;

import action.CustomerAction;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String telphone = "";
        String email = "";
        String password = "";

        CustomerAction customerAction = new CustomerAction();
        Customer customer = null;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");

        if (request.getParameter("username") != null) {
            int isEmail = 0;
            String username = request.getParameter("username");
            int len = username.length();
            for (int i = 0; i < len; i++) {
                if (username.charAt(i) == '@') {
                    int j = i + 1;
                    for (j = i + 1; j < len; j++) {
                        if (username.charAt(j) == '.') {
                            isEmail = 1;
                            break;
                        }
                    }
                    if (j >= len) {
                        isEmail = -1;
                        break;
                    }
                }
            }
            if (isEmail == 0) {
                telphone = username;
                customer = customerAction.get(telphone);
            } else if (isEmail > 0) {
                email = username;
                customer = customerAction.get(email, 0);
            } else {
                //数据处理


            }
        }
        if (request.getParameter("password") != null) {
            password = request.getParameter("password");
        }

        if (customer.getPassword().equals(password)) {
            response.sendRedirect("https://www.vmall.com/");
        } else {
            //用户名或者密码错误

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);

    }
}
