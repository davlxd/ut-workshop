import java.io.*;
import java.util.Random;

/**
 * Created by xdli on 2/26/14.
 */
public class GuessGame {
    private InputStream inputStream;
    private OutputStream outputStream;
    private CompareTwoNumbers compareTwoNumbers;
    private RandomNumberGenerator randomNumberGenerator;

    public GuessGame(InputStream inputStream, OutputStream outputStream,
                     CompareTwoNumbers compareTwoNumbers, RandomNumberGenerator randomNumberGenerator) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.compareTwoNumbers = compareTwoNumbers;
        this.randomNumberGenerator = randomNumberGenerator;
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
        String challenge = randomNumberGenerator.generate();
        int count = 0;
        try {
            outputStream.write("Welcome!".getBytes());

            while(count++ < 6) {
                outputStream.write("Please input your guess:\n".getBytes());
                String guess = readUserInput();
                try {
                    verifyUserInput(guess);
                } catch (Exception e) {
                    outputStream.write(e.getMessage().getBytes());
                }
                String xaxb = compareTwoNumbers.countAB(challenge, guess) + "\n";
                outputStream.write(xaxb.getBytes());

                if (xaxb.equals("4A0B\n")) {
                    outputStream.write("Congratulations!\n".getBytes());
                    return ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new GuessGame(System.in, System.out,
                new CompareTwoNumbers(), new RandomNumberGenerator(new Random()))
                .gameStart();
    }
}
