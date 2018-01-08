import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Message {
    private Date date = new Date();//дата создания
    private String from;//от кого
    private String to;//кому
    private String text;//сообщение
//    private String room;// какая комната

    public Message(String from, String text) {
        this.from = from;
        this.text = text;
    }

    public String toJSON() {//преобразователь в формат JSON
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public static Message fromJSON(String s) {// преобразователь из JSON
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, Message.class);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(date)
                .append(", From: ").append(from).append(", To: ").append(to)
                .append("] ").append(text)
                .toString();
    }

    public int send(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        try {
            String json = toJSON();
            os.write(json.getBytes(StandardCharsets.UTF_8));
            return conn.getResponseCode();
        } finally {
            os.close();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public String getRoom() {
//        return room;
//    }
}


//import com.google.gson.Gson;
//		import com.google.gson.GsonBuilder;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.Serializable;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.text.SimpleDateFormat;
//		import java.util.Date;
//
////обьект сообщение
//public class Message { //сохранение состояния объекта в последовательность байт
//
//	private static final long serialVersionUID = 1L; //версия
//
//	private Date date = new Date(); //дата создания
//	private String from; //от кого
//	private String to;//кому
//	private String text;//сообщение
//	private int counter;

//	public Message(String from, String text) {
//		this.from = from;
//		this.text = text;
//	}

//	public String toJSON() { //преобразователь в формат JSON
//		Gson gson = new GsonBuilder().create();
//		return gson.toJson(this);
//	}
//
//	public static Message fromJSON(String s) { // преобразователь из JSON
//		Gson gson = new GsonBuilder().create();
//		return gson.fromJson(s, Message.class);
//	}
//
//	@Override
//	public String toString() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss");
//		return new StringBuilder()
//				.append("[")
//				.append("From: ")
//				.append(from)
//				.append(", To: ")
//				.append(to)
//				.append(", ")
//				.append(dateFormat.format(date))
//				.append("] ")
//				.append(text).toString();
//	}
//	public int send(String url) throws IOException {
//		URL obj = new URL(url);
//		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
//
//		conn.setRequestMethod("POST");
//		conn.setDoOutput(true);
//
//		OutputStream os = conn.getOutputStream();
//		try {
//			String json = toJSON();
//			os.write(json.getBytes(StandardCharsets.UTF_8));
//			return conn.getResponseCode();
//		} finally {
//			os.close();
//		}
//	}
//
//	//геттеры и сеттеры
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public String getFrom() {
//		return from;
//	}
//
//	public void setFrom(String from) {
//		this.from = from;
//	}
//
//	public String getTo() {
//		return to;
//	}
//
//	public void setTo(String to) {
//		this.to = to;
//	}
//
//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}
//
//	public int getCounter() {
//		return counter;
//	}
//
//	public void setCounter(int counter) {
//		this.counter = counter;
//	}
//}