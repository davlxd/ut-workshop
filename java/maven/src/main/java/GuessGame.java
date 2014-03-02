import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by lxd on 2/3/14.
 */
public class GuessGame {
    private InputStream inputStream;
    private OutputStream outputStream;

    public GuessGame(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void gameStart() throws IOException{
        outputStream.write("Welcome!\n".getBytes());
        int count = 6;
        while (count > 0) {
            String msg = "Please input your guess(" +count+"):";
            outputStream.write(msg.getBytes());

            count -= 1;
        }
    }
}
