import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetThread implements Runnable {
    private final Gson gson;
    private final String userName;
    private final String password;
    private int n;

    public GetThread(String userName, String password) {
        gson = new GsonBuilder().create();
        this.userName = userName;
        this.password = password;

    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
//                URL url = new URL(Utils.getURL() + "/get?from=" + n);
                URL url = new URL(Utils.getURL() + "/get?userName=" + userName + "&password=" + password + "&from=" + n );
                HttpURLConnection http = (HttpURLConnection) url.openConnection();

                InputStream is = http.getInputStream();
                try {
                    byte[] buf = requestBodyToArray(is);
                    String strBuf = new String(buf, StandardCharsets.UTF_8);

                    JsonMessages list = gson.fromJson(strBuf, JsonMessages.class);
                    if (list != null) {
                        for (Message m : list.getList()) {
                            System.out.println(m);
                            n++;
                        }
                    }
                } finally {
                    is.close();
                }

                Thread.sleep(500);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private byte[] requestBodyToArray(InputStream is) throws IOException {// запрос тела для массива
        ByteArrayOutputStream bos = new ByteArrayOutputStream();// поток вывода байт
        byte[] buf = new byte[10240];// буфер
        int r;

        do {
            r = is.read(buf);// 1
            if (r > 0) bos.write(buf, 0, r);//если есть что читать
        } while (r != -1);// пока все не вычитает

        return bos.toByteArray();
    }
}


//import com.google.gson.Gson;
//        import com.google.gson.GsonBuilder;
//
//        import java.io.InputStream;
//        import java.net.HttpURLConnection;
//        import java.net.URL;
//
////параллельный коток, который будет проверять не появились ли новые сообщения на сервере
//public class GetThread extends Thread { //наследуемся от потока
//
//    private String too; //в какой чат адресовано сообщение
//    boolean priv;//флаг приватные сообщения
//    private int n; //счетчик уже загруженных сообщений
//
//    public GetThread(String too, boolean priv){
//        this.too = too;
//        this.priv = priv;
//    }
//
//    public void setN(int n) {
//        this.n = n;
//    }
//
//    public int getN() {
//        return n;
//    }
//
//    @Override
//    public void run() { //метод который будет выполнятся в параллельном потоке
//        try {
//            while (!isInterrupted()) { //повторять пока не прервали
//
//                try { //чуток спим, чтоб не так напрягался процессор
//                    currentThread().sleep(100);
//                }
//                catch (InterruptedException e){
//                    return; //если во время сна прервали, выходим из метода
//                }
//                // передаем параметр from = сколько сообщений уже прочитано,
//                // и too - кому адресовано сообщение(main-chat, chat-room или личное)
//
//                URL url = new URL("http://localhost:8080/get?from="+n+"&too="+too+"&priv="+priv); //URL ссылка на сервлет /get с параметром n -
//                // колличество уже проитанных сообщений
//                HttpURLConnection http = (HttpURLConnection) url.openConnection(); //открываем url соединение
////                Main.addCookie(http);//добавляем Cookie
//
//                try(InputStream is = http.getInputStream()) {// получаем входящий поток из url соединения
//                    int sz = is.available(); //спрашиваем сколько байт доступно для чтения
//                    if (sz > 0) {//если есть что читать
//                        byte[] buf = new byte[is.available()]; //создаем массив байт (на количество доступных для чтения байт)
//                        is.read(buf); //читаем байты в буфер
//                        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //создаем обьект gson
//                        Message[] list = gson.fromJson(new String(buf), Message[].class); //парсим данные из byte массива
//                        //в котором записан массив сообщений в JSON формате
//                        for (Message m : list) { //выводим все сообщения на экран, итерируем счетчик
//                            n = m.getCounter()+1;
//                            System.out.println(m);
//                        }
//                    }
//                }
//            }
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//            return;
//        }
//    }
//}