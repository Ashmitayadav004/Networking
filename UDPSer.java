package Networking;

//receiving data via sockets
import java.net.*;

public class UDPSer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(234);
            byte[] b1 = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b1, b1.length);
            ds.receive(dp);// byte to int
            String str = new String(dp.getData(), 0, dp.getLength());
            int num = Integer.parseInt(str);
            System.out.println("numbers " + num);
            int result = num * num;
            System.out.println("REsult " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
