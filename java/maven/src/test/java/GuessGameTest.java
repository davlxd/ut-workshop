import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by xdli on 2/26/14.
 */
public class GuessGameTest {

    @Test
    public void when_game_begin_should_print_welcome_message() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GuessGame guessGame = new GuessGame(System.in, byteArrayOutputStream);

        guessGame.gameStart();
        assertThat(byteArrayOutputStream.toString()).isEqualTo("Welcome! Please input your guess:\n");
    }

    @Test
    public void should_read_line_user_input_correctly() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1234".getBytes());

        GuessGame guessGame = new GuessGame(byteArrayInputStream, System.out);
        assertThat(guessGame.readUserInput()).isEqualTo("1234");
    }

    @Test
    public void should_throw_exception_if_user_input_not_4_digit() {
        GuessGame guessGame = new GuessGame(System.in, System.out);

        try {
            guessGame.verifyUserInput("123");
        } catch (Exception e) {
            assertThat(e).hasMessageContaining("exactly 4 digits");
        }

    }


    @Test
    public void should_throw_exception_if_user_input_not_just_digit() {
        GuessGame guessGame = new GuessGame(System.in, System.out);

        try {
            guessGame.verifyUserInput("12a3");
        } catch (Exception e) {
            assertThat(e).hasMessageContaining("only contain digit");
        }

    }


    @Test
    public void should_throw_exception_if_user_input_duplicate_digit() {
        GuessGame guessGame = new GuessGame(System.in, System.out);

        try {
            guessGame.verifyUserInput("1223");
        } catch (Exception e) {
            assertThat(e).hasMessageContaining("unique to each other");
        }

    }

}
