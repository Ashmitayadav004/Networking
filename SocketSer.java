// package Networking;

// import java.net.*;
// import java.io.*;

// public class SocketSer {
//     public static void main(String[] args) {
//         try {
//             ServerSocket ss = new ServerSocket(12345);
//             System.out.println("Server bob is listening");
//             Socket s = ss.accept();
//             System.out.println("Connection made with cli and ser");

//             DataInputStream din = new DataInputStream(System.in); // read from keyboard
//             DataInputStream ssin = new DataInputStream(s.getInputStream()); // read from client socket
//             DataOutputStream ssout = new DataOutputStream(s.getOutputStream());// output to client socket
//             String str;
//             while (true) {
//                 str = ssin.readUTF();
//                 System.out.println("Client said" + str);
//                 if(str.equals("bye"))break;
//                 System.out.println("Enter the data for Client");
//                 str = din.readLine();
//                 ssout.writeUTF(str);
                
//             }

//             // reading and acceptin data from client side to display
//             // ObjectInputStream in = new ObjectInputStream(s.getInputStream());
//             // String str = (String) in.readUTF();
//             // System.out.println(str);
//             // in.close();
//             // ss.close();

//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }





package Networking;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SocketSer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);
            System.out.println("Server is listening");
            Socket s = ss.accept();
            System.out.println("Connection established with client");

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            String clientMessage;
            while (true) {
                // Read message from client
                clientMessage = (String) in.readUTF();
                if (clientMessage.equalsIgnoreCase("byee")) {
                    System.out.println("Client ended the chat.");
                    break;
                }
                System.out.println("Client: " + clientMessage);

                // Server sends a message to the client
                System.out.print("Enter message to client: ");
                String serverMessage = scanner.nextLine();
                out.writeUTF("Server: " + serverMessage);
                out.flush();

                if (serverMessage.equalsIgnoreCase("byee")) {
                    System.out.println("Server ended the chat.");
                    break;
                }
            }
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}