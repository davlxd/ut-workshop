import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by xdli on 2/26/14.
 */
public class GuessGameTest {

//    @Test
    public void when_game_begin_should_print_welcome_message() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GuessGame guessGame = new GuessGame(System.in, byteArrayOutputStream,
                mock(CompareTwoNumbers.class), mock(RandomNumberGenerator.class));

        guessGame.gameStart();
        assertThat(byteArrayOutputStream.toString()).isEqualTo("Welcome! Please input your guess:\n");
    }

    @Test
    public void should_read_line_user_input_correctly() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1234".getBytes());

        GuessGame guessGame = new GuessGame(byteArrayInputStream, System.out,
                mock(CompareTwoNumbers.class), mock(RandomNumberGenerator.class));
        assertThat(guessGame.readUserInput()).isEqualTo("1234");
    }


    private GuessGame mockGuessGame() {
        return new GuessGame(System.in, System.out,
                mock(CompareTwoNumbers.class), mock(RandomNumberGenerator.class));
    }
    @Test
    public void should_throw_exception_if_user_input_not_4_digit() {
        GuessGame guessGame = mockGuessGame();

        try {
            guessGame.verifyUserInput("123");
        } catch (Exception e) {
            assertThat(e).hasMessageContaining("exactly 4 digits");
        }

    }


    @Test
    public void should_throw_exception_if_user_input_not_just_digit() {
        GuessGame guessGame = mockGuessGame();

        try {
            guessGame.verifyUserInput("12a3");
        } catch (Exception e) {
            assertThat(e).hasMessageContaining("only contain digit");
        }

    }


    @Test
    public void should_throw_exception_if_user_input_duplicate_digit() {
        GuessGame guessGame = mockGuessGame();

        try {
            guessGame.verifyUserInput("1223");
        } catch (Exception e) {
            assertThat(e).hasMessageContaining("unique to each other");
        }

    }

    @Test
      public void guess_game_should_be_is_a_6_time_loop() {
        CompareTwoNumbers compareTwoNumbers = new CompareTwoNumbers(); //Didn't mock CompareTwoNumbers
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);

        when(randomNumberGenerator.generate()).thenReturn("1234");


        byte[] mockUserInput = new byte[10240];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(mockUserInput, 1024 * i + j, 1024 * i + j + 1, (""+(j+5)).getBytes()[0]);
            }
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


        GuessGame guessGame = new GuessGame(byteArrayInputStream, byteArrayOutputStream,
                compareTwoNumbers, randomNumberGenerator);

        guessGame.gameStart();


        StringBuffer expectOutput = new StringBuffer();
        expectOutput.append("Welcome!");
        for (int i = 0; i < 6; i++) {
            expectOutput.append("Please input your guess:\n");
            expectOutput.append("0A0B\n");
        }
        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectOutput.toString());
    }


    @Test
    public void guess_game_should_terminal_in_advance_if_guess_match() {
        CompareTwoNumbers compareTwoNumbers = new CompareTwoNumbers(); //Didn't mock CompareTwoNumbers
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);

        when(randomNumberGenerator.generate()).thenReturn("1234");


        byte[] mockUserInput = new byte[10240];
        Arrays.fill(mockUserInput, 0, 1, (byte)'4');
        Arrays.fill(mockUserInput, 1, 2, (byte)'3');
        Arrays.fill(mockUserInput, 2, 3, (byte)'2');
        Arrays.fill(mockUserInput, 3, 4, (byte)'1');

        Arrays.fill(mockUserInput, 1024, 1025, (byte)'1');
        Arrays.fill(mockUserInput, 1025, 1026, (byte)'2');
        Arrays.fill(mockUserInput, 1026, 1027, (byte)'3');
        Arrays.fill(mockUserInput, 1027, 1028, (byte)'4');
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


        GuessGame guessGame = new GuessGame(byteArrayInputStream, byteArrayOutputStream,
                compareTwoNumbers, randomNumberGenerator);

        guessGame.gameStart();


        StringBuffer expectOutput = new StringBuffer();
        expectOutput.append("Welcome!");
        expectOutput.append("Please input your guess:\n");
        expectOutput.append("0A4B\n");
        expectOutput.append("Please input your guess:\n");
        expectOutput.append("4A0B\n");
        expectOutput.append("Congratulations!\n");

        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectOutput.toString());
    }


    @Test
    public void guess_game_should_terminal_in_advance_if_guess_match_and_with_invalid_input() {
        CompareTwoNumbers compareTwoNumbers = new CompareTwoNumbers(); //Didn't mock CompareTwoNumbers
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);

        when(randomNumberGenerator.generate()).thenReturn("1234");


        byte[] mockUserInput = new byte[10240];
        Arrays.fill(mockUserInput, 0, 1, (byte)'4');
        Arrays.fill(mockUserInput, 1, 2, (byte)'3');
        Arrays.fill(mockUserInput, 2, 3, (byte)'2');

        Arrays.fill(mockUserInput, 1024, 1025, (byte)'1');
        Arrays.fill(mockUserInput, 1025, 1026, (byte)'2');
        Arrays.fill(mockUserInput, 1026, 1027, (byte)'3');
        Arrays.fill(mockUserInput, 1027, 1028, (byte)'4');
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockUserInput);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


        GuessGame guessGame = new GuessGame(byteArrayInputStream, byteArrayOutputStream,
                compareTwoNumbers, randomNumberGenerator);

        guessGame.gameStart();


        StringBuffer expectOutput = new StringBuffer();
        expectOutput.append("Welcome!");
        expectOutput.append("Please input your guess:\n");
        expectOutput.append("User input should contain exactly 4 digits\n");
        expectOutput.append("Please input your guess:\n");
        expectOutput.append("4A0B\n");
        expectOutput.append("Congratulations!\n");

        assertThat(byteArrayOutputStream.toString()).isEqualTo(expectOutput.toString());
    }

}
