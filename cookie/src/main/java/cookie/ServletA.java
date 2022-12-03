

package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author zzy
 * @date 2022-11-22 21:15
 */
@WebServlet("/ServletA")
public class ServletA extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String name = "name";
        String value = "张三";

        value = URLEncoder.encode(value, "UTF-8");
        System.out.println(value);


        Cookie cookie = new Cookie(name,value);
        Cookie cookieName = new Cookie("userName", "xi1");
        Cookie cookiePwd = new Cookie("Pwd", "123");
        cookie.setMaxAge(60*10);
        response.addCookie(cookie);
        response.addCookie(cookieName);
        response.addCookie(cookiePwd);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
