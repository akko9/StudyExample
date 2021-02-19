package SocketDemo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket=null;
        OutputStream outputStream=null;
        ByteArrayOutputStream bos=null;
        FileInputStream fileInputStream=null;
        try {
            //获得ip+端口号对象
            InetAddress address=InetAddress.getByName("127.0.0.1");
            //客户端连接对象
            socket=new Socket(address,9001);
            //获得输出流
            outputStream = socket.getOutputStream();
//            //发送字符串
//          outputStream.write("你好!!!!!".getBytes());
            //发送图片
            fileInputStream=new FileInputStream("IOExample\\0.jpg");
            byte[] bytes=new byte[1024];
            int len=0;
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
            socket.shutdownOutput();
            System.out.println("图片上传成功!");
            //获取信息
            InputStream inputStream = socket.getInputStream();
            bos=new ByteArrayOutputStream();
            byte[] buffers=new byte[5];
            int length=0;
            while ((length=inputStream.read(buffers))!=-1){
                bos.write(buffers,0,length);
            }
            System.out.println(bos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
