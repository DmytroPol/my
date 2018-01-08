package ua.kiev.prog;

import java.util.Map;
import java.util.TreeMap;


/**
 * Serg
 */
public class UserList {

    private static final UserList userList = new UserList();
    private final TreeMap<String, User> users = new TreeMap<>();

    private UserList() {

    }

    public static UserList getInstance() {
        return userList;
    }

    public synchronized int addUser(String userName, String password) {
        int result = 200;
        MessageList msgList = MessageList.getInstance();
        String message = "";
        if (!users.containsKey(userName)) {
            users.put(userName, new User(userName, password));
            message = "REGISTERED NEW USER - " + userName;}
//        } else {
//            if (users.get(userName).getPassword().equals(password)) {
//                message = "USER " + userName + " LOGGED IN";
//            } else {
//                message = "USER " + userName + " LOGIN FAILED";
//                result = 401;
//            }
//        }
        Message m = new Message("SYSTEM", message);
        msgList.add(m);
        return result;
    }

    public User getUser(String name) {
        return users.get(name);
    }

    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<String, User> stringUserEntry : users.entrySet()) {
            result += stringUserEntry.getKey() + ",";
        }
        return result.substring(0, result.length() - 1);
    }

}