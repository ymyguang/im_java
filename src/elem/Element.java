package elem;

import function.ListenFromServer;
import function.SendMessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * @another ymyguang
 * @date 4/17/2021 5:29 PM
 */

public abstract class Element {
    protected DataInputStream in;
    protected DataOutputStream out;

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    abstract public boolean start();


//   开启接受消息和发送消息的线程
    public void run(Element element) {
        new Thread(new ListenFromServer(element)).start();
        new Thread(new SendMessage(element)).start();
    }
}
