package ua.kiev.prog;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetListServlet extends HttpServlet {

	private MessageList msgList = MessageList.getInstance();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String fromStr = req.getParameter("from");
        String userName = req.getParameter("userName"); //Serg
        String password = req.getParameter("password"); //Serg
		int from = 0;
		try {
			from = Integer.parseInt(fromStr);
		} catch (Exception ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
		}
//serg
//        int res = 200;
//        UserList userList = UserList.getInstance();
//        User user = userList.getUser(userName);
//        if (user == null) {
//            System.out.println("USER " + userName + " DOES NOT EXISTS");
//            return;
//        } else {
//            if (!user.getPassword().equals(password)) {
//                System.out.println("USER " + userName + " - BAD PASSWORD");
//                return;
//            }
//        }

		String json = msgList.toJSON(from);
		if (json != null) {
			OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
			os.write(buf);
		}
	}
}
