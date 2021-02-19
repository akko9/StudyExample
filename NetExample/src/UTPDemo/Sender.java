package UTPDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) {
        DatagramSocket socket= null;
        try {
            InetAddress address=InetAddress.getByName("127.0.0.1");
            socket = new DatagramSocket();
            String str="您好!";
            byte[] bytes=str.getBytes();
            DatagramPacket packet=new DatagramPacket(bytes,0,bytes.length,address,9001);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket!=null){
                socket.close();
            }
        }




    }
}
