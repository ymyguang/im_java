package demo;

import elem.Server;

/**
 * @another ymyguang
 * @date 4/18/2021 4:50 PM
 */
public class ServerDemo {
    public static void main(String[] args) {
        Server server = new Server(18888);
        server.start();
    }
}
