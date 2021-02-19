package UTPDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) {
        try {
            DatagramSocket socket=new DatagramSocket(9001);
            byte[] bytes=new byte[1024];
            DatagramPacket packet=new DatagramPacket(bytes,0,bytes.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
