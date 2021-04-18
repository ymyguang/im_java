package function;

import elem.Element;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @another ymyguang
 * @date 4/17/2021 5:26 PM
 */
public class SendMessage implements Runnable {
    private Element element;
    private String message;
    private DataOutputStream out = null;

    public SendMessage(Element element) {
        this.element = element;
        this.out = element.getOut();
    }

    public void run() {
        Scanner in_put = new Scanner(System.in);
        while (true) {
            message = in_put.nextLine();
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
