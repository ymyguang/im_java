package elem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @another ymyguang
 * @date 4/17/2021 5:26 PM
 */
public class Client extends Element {
    private Socket socket;
    private String servmeString;
    private int servort;

    public Client(String server, int port) {
        this.servmeString = server;
        this.servort = port;
    }

    public boolean start() {
        // 创建连接道服务器
        try {
            socket = new Socket(servmeString, servort);
        } catch (Exception e) {
            System.out.println("Error connection to server");
            return false;
        }

        System.out.println("Connection accepted");
        // 初始化输入输出流
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {
            System.out.println("Exception creat Input\\Output Stream:" + e);
            return false;
        }
        super.run(this);

        return true;
    }
}
