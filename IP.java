package Networking;

import java.net.InetAddress;

public class IP {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.rajagiri.edu");
            System.out.println("Inet address  " + ip);
            System.out.println("host name  " + ip.getHostName());
            System.out.println("ip " + ip.getHostAddress());

            InetAddress ind = InetAddress.getLocalHost();
            System.out.println("Inet address  " + ind);
            System.out.println("host name  " + ind.getHostName());
            System.out.println("ip " + ind.getHostAddress());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
