package SocketDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket ss= null;
        Socket accept = null;
        InputStream inputStream = null;
        //ByteArrayOutputStream bos= null;
        FileOutputStream outputStream=null;
        try {
            ss = new ServerSocket(9001);
            accept = ss.accept();
            inputStream = accept.getInputStream();
            byte[] buffers=new byte[5];
            int len=0;
//            //获得客户端发送的文字
//            bos = new ByteArrayOutputStream();
//
//            while ((len=inputStream.read(buffers))!=-1){
//                bos.write(buffers,0,len);
//            }
//            System.out.println(bos.toString());
            //获得客户端发送的图片
            outputStream=new FileOutputStream("NetExample\\1.jpg");
            while ((len=inputStream.read(buffers))!=-1){
                outputStream.write(buffers,0,len);
            }
            System.out.println("服务器端保存成功");
            //发送成功返回到客户端
            OutputStream os = accept.getOutputStream();
            os.write("图片已接收,发送成功!".getBytes());
            accept.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (bos!=null){
//                try {
//                    bos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
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
            if (accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }
}
