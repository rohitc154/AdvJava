// package SocketPrograms.Socket01;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerTest {
    public ServerSocket ss;

    public ServerTest() throws IOException {
        ss = new ServerSocket(13, 5);
    }

    public void serve() throws IOException {
        Socket s = null;
        s = ss.accept();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        out.write("Day & Time : " + (new Date()).toString());
        out.close();
    }

    public static void main(String arg[]) throws IOException {
        ServerTest st = new ServerTest();
        System.out.println("Server is running......");
        for (;;)
            st.serve();
    }
}