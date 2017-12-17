package dmytropolishchuk2.gmail.com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dmytropolishchuk2.gmail.com.FormServlet", urlPatterns = "/answer")// аннотация для сервлета
public class FormServlet extends HttpServlet {

   private String adress = "<html> <head><title>Questionary</title>" +// где выводить результат
            "</head><body>%s</body></html>";

    final int[] array = new int[6];// может быть инициализирован только один раз

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        final String name = req.getParameter("name");// запрос параметров
        final String surName = req.getParameter("surname");
        final String age = req.getParameter("age");
        final String per = req.getParameter("period");
        final String lan = req.getParameter("lang");
        synchronized (array) {
            if (per.equals("<1")) {
                array[0]++;
            }
            if (per.equals(">2")) {
                array[1]++;
            }
            if (per.equals(">3")) {
                array[2]++;
            }
            if (lan.equals("Java")) {
                array[3]++;
            }
            if (lan.equals("Python")) {
                array[4]++;
            }
            if (lan.equals("C++")) {
                array[5]++;
            }

        }

        String result = "<p><h4>  name-> " + name + ",  surname-> " + surName + ",  age-> " + Integer.parseInt(age) + " years </p>" +
                "<p>period: less 1 year-> " + array[0] + ", more 2 years-> " + array[1] + ", more 3 years-> " + array[2] + "</p>" +
                "<p> language: Java-> " + array[3] + "; Python-> " + array[4] + " ; C++-> " + array[5] + "</h4></p>";
        try {
            PrintWriter pw = resp.getWriter();
            pw.println(String.format(adress, result));
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

