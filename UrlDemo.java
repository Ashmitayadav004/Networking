package Networking;

import java.net.*;

public class UrlDemo {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.amazon.com/");
            System.out.println("Url is " + u.toString());
            System.out.println("The protocol is " + u.getProtocol());
            System.out.println("Host name" + u.getHost());
            System.out.println("Port num" + u.getPort());
            System.out.println("Default port no" + u.getDefaultPort());
            System.out.println("Query" + u.getQuery());
            System.out.println("File" + u.getFile());
            System.out.println("Path" + u.getPath());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}