package board;

import java.util.Arrays;

public class HistoryCaretaker {
    private Memento[] history;

    private Board board;

    public HistoryCaretaker(Board board) {
        this.board = board;
        this.history = new Memento[0];
    }

    public void saveMemento() {
        this.history = Arrays.copyOf(this.history, this.history.length + 1);
        this.history[this.history.length - 1] = this.board.save();
    }

    public void restoreMemento(int turn) {
        if (this.history[turn] != null) {
            this.history[turn].restore();
        }
    }

    public void restoreLastMemento() {
        if (this.history.length > 0) {
            this.history[this.history.length - 1].restore();
        }
    }
}
