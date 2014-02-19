/**
 * Created by xdli on 2/19/14.
 */
public class Node {
    private boolean matched;
    private int index;
    private char ch;

    public Node(char ch, int index) {
        this.ch = ch;
        this.index = index;

        matched = false;
    }

    public char getCh() {
        return ch;
    }

    public void setMatched() {
        matched = true;
    }

    public boolean isMatched() {
        return matched;
    }
}
