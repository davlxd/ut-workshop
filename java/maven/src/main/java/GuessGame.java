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

    public void verifyUserInput(String userInput) throws Exception {

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) < '0' || userInput.charAt(i) > '9')
                throw new Exception("User input should only contain digit");
        }

        if (userInput.length() != 4){
            throw new Exception("User input should contain exactly 4 digits");
        }


        for (int i = 0; i < userInput.length(); i++) {
            for (int j = 0; j < userInput.length() && i != j; j++) {
                if (userInput.charAt(i) == userInput.charAt(j))
                    throw new Exception("User input digit should unique to each other");
            }
        }
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
