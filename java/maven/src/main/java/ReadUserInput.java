import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lxd on 3/3/14.
 */
public class ReadUserInput {
    private InputStream inputStream;

    public ReadUserInput(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String readLine() throws IOException {
        byte[] userInput = new byte[1024];
        inputStream.read(userInput);
        return new String(userInput).trim();
    }
//
//    public static void main(String args[]) throws IOException {
//        String txt =  new ReadUserInput(System.in).readLine();
//        System.out.println(txt);
//    }
}
