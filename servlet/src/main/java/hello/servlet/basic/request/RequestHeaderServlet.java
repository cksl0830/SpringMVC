package hello.servlet.basic.request;

import hello.servlet.basic.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="requestHeaderServlet",urlPatterns = "/request-header")
public class RequestHeaderServlet extends HelloServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

