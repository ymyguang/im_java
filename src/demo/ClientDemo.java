package demo;

import elem.Client;
/**
 * @another ymyguang
 * @date 2/2/2021 11:56 AM
 */


public class ClientDemo {
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 18888);
        client.start();
    }
}
// 发送消息

