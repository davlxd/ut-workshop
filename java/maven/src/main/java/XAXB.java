import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xdli on 2/19/14.
 */
public class XAXB {


    public List<Node> generateNode(String str) {
        List<Node> l = new ArrayList<Node>();
        for (int i = 0; i < str.length(); i++) {
            l.add(new Node(str.charAt(i), i));
        }
        return l;
    }

    public String formatOutput(int countA, int countB) {
        return countA + "A" + countB + "B";
    }


    public int countA(List<Node> challenges, List<Node> guesses) {
        int count = 0;

        Iterator<Node> challengesIter = challenges.iterator();
        Iterator<Node> guessesIter = guesses.iterator();

        while (challengesIter.hasNext()) {
            Node challengeNode = challengesIter.next();
            Node guessNode = guessesIter.next();
            if (!challengeNode.isMatched() && !guessNode.isMatched() &&
                    challengeNode.getCh() == guessNode.getCh()) {
                count += 1;
                challengeNode.setMatched();
                guessNode.setMatched();
            }

        }

        return count;
    }

    public int countB(List<Node> challenges, List<Node> guesses) {
        int count = 0;

        for (Node guess : guesses) {
            if (guess.isMatched())
                continue;
            for (Node challenge : challenges) {
                if (challenge.isMatched())
                    continue;
                if (guess.getCh() == challenge.getCh()) {
                    count += 1;
                    challenge.setMatched();
                    guess.setMatched();
                }
            }
        }

        return count;
    }


    public String countAB(String challenge, String guess) {
        int countA = 0, countB = 0;

        List<Node> challenges = generateNode(challenge);
        List<Node> guesses = generateNode(guess);


        countA = countA(challenges, guesses);
        countB = countB(challenges, guesses);

        return formatOutput(countA, countB);


    }
}
