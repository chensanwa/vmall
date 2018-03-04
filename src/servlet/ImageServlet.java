package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ImageServlet")
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(100,40,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        Color color = new Color(200,250,255);
        graphics.setColor(color);
        graphics.fillRect(0,0,100,40);

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        int len = chars.length;
        int index = 0;
        for(int i=0;i<4;i++){
            index = random.nextInt(len);
            graphics.setColor(new Color(random.nextInt(200),random.nextInt(188),random.nextInt(55)));
            graphics.drawString(chars[index]+"",(i*20)+10,25+random.nextInt(10));
            graphics.drawLine(random.nextInt(100),random.nextInt(40),random.nextInt(100),random.nextInt(40));
            stringBuffer.append(chars[index]);
        }
        request.getSession().setAttribute("piccode",stringBuffer.toString());
        ImageIO.write(bufferedImage,"JPG",response.getOutputStream());
    }
}
