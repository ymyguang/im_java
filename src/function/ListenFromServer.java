package function;
import java.io.DataInputStream;
import java.io.IOException;

import elem.Element;

/**
 * @another ymyguang
 * @date 4/17/2021 5:26 PM
 *
 */ // 输出来自服务端消息
public class ListenFromServer implements Runnable {
    private DataInputStream in = null;
    private Element element;

    public ListenFromServer(Element element) {
        this.element = element;
        this.in = element.getIn();
    }

    public void run() {
        System.out.print("Thread started successfully!\n");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            try {
                String message = in.readUTF();
                if (message != null) {
                    System.out.println("server message：" + message);
                }
            } catch (IOException e) {
                System.out.print("Server has close the connection.");
                try {
                    in.close();
                    return;
                } catch (Exception ignored) {
                }
            }
        }
    }
}
