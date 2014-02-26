import java.io.*;

/**
 * Created by xdli on 2/26/14.
 */
public class GuessGame {
    private InputStream inputStream;
    private OutputStream outputStream;

    public GuessGame(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public String readUserInput() {
        byte[] userInput = new byte[1024];
        try {
            inputStream.read(userInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(userInput).trim();
    }

    public void gameStart() {
        try {
            outputStream.write("Welcome! Please input your guess:\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new GuessGame(System.in, System.out).gameStart();
    }
}
