package ua.kiev.prog;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

    private MessageList msgList = MessageList.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {// запрос параметров
        byte[] buf = requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Message msg = Message.fromJSON(bufStr);
        if (msg != null) {
            if (msg.getText().substring(0, (msg.getText().length()<1?0:1)).equals("/")) {
                System.out.println("COMMAND: " + msg.getText());
                resp.setStatus(doCommand(msg));
            } else {
                msgList.add(msg);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private byte[] requestBodyToArray(HttpServletRequest req) throws IOException {
        InputStream is = req.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }
    
    private int doCommand(Message msg) {
        UserList userList = UserList.getInstance();
        MessageList msgList = MessageList.getInstance();
        int result = 200;

        String s = msg.getText();
        String[] params = s.split(" ");
        String lastparam="";
        for (int i = 2; i < params.length; i++) {
            lastparam += params[i]+" ";
        }
        switch (params[0]) {
            case "/register":
                result = userList.addUser(params[1], params[2]);
                msgList.add(new Message("SYSTEM",msg.getFrom(),"User(s) added in the chat: "+userList.toString()));
                break;
            case "/private":
                msgList.add(new Message(msg.getFrom(),params[1],lastparam));
                break;
            case "/userlist":
                msgList.add(new Message("SYSTEM",msg.getFrom(),"Users in chat: "+userList.toString()));
                break;
            case "/setsuser":
                userList.getUser(msg.getFrom()).setStatus(params[1]);
                msgList.add(new Message("SYSTEM",msg.getFrom(),"Your status is "+userList.getUser(msg.getFrom()).getStatus()));
                break;
            case "/getsuser":
                msgList.add(new Message("SYSTEM",msg.getFrom(),"Status of user "+params[1]+" is "+userList.getUser(params[1]).getStatus()));
                break;
        }
        System.out.println(msg.getText());
        return result;
    }
}
