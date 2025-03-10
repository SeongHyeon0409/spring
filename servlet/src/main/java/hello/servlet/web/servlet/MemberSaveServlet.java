package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")

public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberSaveServlet.service");
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter w = resp.getWriter();
        w.write(new StringBuilder().append("<html>\n").append("<head>\n").append(" <meta charset=\"UTF-8\">\n").append("</head>\n").append("<body>\n").append("성공\n").append("<ul>\n").append(" <li>id=").append(member.getId()).append("</li>\n").append(" <li>username=").append(member.getUsername()).append("</li>\n").append(" <li>age=").append(member.getAge()).append("</li>\n").append("</ul>\n").append("<a href=\"/index.html\">메인</a>\n").append("</body>\n").append("</html>").toString());
    }
}
