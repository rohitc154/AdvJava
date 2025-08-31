package SocketPrograms.Socket02;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket S = new Socket("localhost", 2222);
        System.out.println("Connected to Server !!");
        PrintWriter pw = new PrintWriter(S.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(S.getInputStream()));
        pw.println("Hello from the client !!");
        String serverMessage = in.readLine();
        System.out.println("Received from Server:" + serverMessage);
        S.close();
    }
}
