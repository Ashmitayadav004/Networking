// package Networking;

// import java.net.*;
// import java.io.*;

// public class SocketCli {
//     public static void main(String[] args) {
//         try {
//             Socket s = new Socket("localhost", 12345);
//             System.out.println("Waiting for connection");
//             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
//             DataInputStream kin = new DataInputStream(System.in); // read from keyboard
//             DataInputStream sin = new DataInputStream(s.getInputStream()); // read from socket
//             DataOutputStream sout = new DataOutputStream(s.getOutputStream());// output to server side
//             String str;
//             while (true) {
//                 str = sin.readUTF();
//                 System.out.println("Server said" + str);
//                 if(str.equals("bye"))break;
//                 System.out.println("Enter the data for server");
//                 str = kin.readLine();
//                 sout.writeUTF(str);
//             }

//             // read from keyboard and send to server
//             // DataInputStream din = new DataInputStream(System.in);
//             // System.out.println("Enter your message");
//             // String str = din.readLine();
//             // out.writeUTF(str);
//             // out.writeUTF("Hello bob");

//             // out.close();
//             // s.close();


//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }




package Networking;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SocketCli {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 12345);
            System.out.println("Connected to server");

            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            Scanner scanner = new Scanner(System.in);

            String message;
            while (true) {
                System.out.print("Enter message: ");
                message = scanner.nextLine();
                out.writeUTF(message);
                out.flush();

                if (message.equalsIgnoreCase("byee")) {
                    System.out.println("You ended the chat.");
                    break;
                }

                String response = (String) in.readUTF();
                System.out.println(response);
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}