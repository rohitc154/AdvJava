package SocketPrograms.Socket02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket SS = new ServerSocket(2222);
        System.out.println("Server Listening on Port 2222....");
        Socket CS = SS.accept();
        System.out.println("Client Connected !!...");
        BufferedReader in = new BufferedReader(new InputStreamReader(CS.getInputStream()));
        PrintWriter pw = new PrintWriter(CS.getOutputStream(), true);
        String message = in.readLine();
        System.out.println("Message received from client : " + message);
        pw.println("Hello From Server !!");
        CS.close();
        SS.close();
    }
}
