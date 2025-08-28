// package SocketPrograms.Socket01;

import java.io.*;
import java.net.*;

public class ClientTest {
    String Host;
    Socket soc;

    public ClientTest(String phost) throws IOException {
        this.Host = phost;
    }

    public void getDate() throws IOException {
        soc = new Socket(Host, 13);
        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        System.out.println(br.readLine());
        br.close();
        soc.close();
    }

    public static void main(String arg[]) throws IOException {
        ClientTest ct = new ClientTest(arg[0]);
        ct.getDate();
    }
}
