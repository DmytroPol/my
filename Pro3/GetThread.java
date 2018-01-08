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
