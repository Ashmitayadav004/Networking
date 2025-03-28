package Networking;

//sending data in packets(each packet will hv destination address) through sockets
import java.net.*;

public class UDPCli {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            int i = 10;
            byte[] b = String.valueOf(i).getBytes();
            InetAddress ip = InetAddress.getLocalHost();
            DatagramPacket dp = new DatagramPacket(b, b.length, ip, 234);
            // 4 arguments
            // byte array
            // byte array length
            // inet address
            // port number
            ds.send(dp);
            System.out.println("Sent number: " + i);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}