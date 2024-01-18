package board;

public class HistoryCaretaker {
    private Memento[] history;

    private Board board;

    public HistoryCaretaker(Board board) {
        this.board = board;
    }

    public void saveMemento() {
        this.history[this.history.length] = this.board.save();
    }

    public void restoreMemento(int turn) {
        this.history[turn].restore();
    }

    public void restoreLastMomento() {
        this.history[this.history.length - 1].restore();
    }
}
