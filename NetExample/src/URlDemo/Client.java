package URlDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Client {
    public static void main(String[] args) {
        InputStream inputStream = null;
        FileOutputStream outputStream= null;
        HttpURLConnection urlConnection=null;
        try {
            //定位资源
            URL url=new URL("http://localhost:8080/examples/051231892.jpg");
            //获得连接
            urlConnection= (HttpURLConnection) url.openConnection();
            //开始连接
            urlConnection.connect();
            //获得输入流
            inputStream = urlConnection.getInputStream();
            outputStream = new FileOutputStream("NetExample\\3.jpg");
            byte[] bytes=new byte[1024];
            int len=0;
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection!=null){
                urlConnection.disconnect();
            }
        }



    }
}
