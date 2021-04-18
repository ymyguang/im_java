package elem;
/**
* @another ymyguang
* @date 2/1/2021 3:27 PM
*/

import java.net.*;
import java.io.*;

public class Server extends Element{
    private Socket connectionSocket;
    private ServerSocket serverSocket;
    private int port;
    public Server (int port) {
        this.port = port;
    }
    public boolean start() {
        try {
            serverSocket = new ServerSocket(this.port);
        } catch (Exception ignored) {
        }

        try {
            connectionSocket = serverSocket.accept();
            out = new DataOutputStream(connectionSocket.getOutputStream());
            in = new DataInputStream(connectionSocket.getInputStream());
            System.out.println("Connected by client");
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run(this);
        return true;
    }

}