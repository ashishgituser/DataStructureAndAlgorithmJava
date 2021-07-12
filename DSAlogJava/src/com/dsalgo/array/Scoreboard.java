package com.dsalgo.array;

import java.util.Arrays;

public class Scoreboard {
    private final GameEntry[] board;
    private int noOfEntries = 0;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public static void main(String[] arg) {
        GameEntry gameEntry1 = new GameEntry("ashish", 233);
        GameEntry gameEntry2 = new GameEntry("anshu", 122);
        GameEntry gameEntry3 = new GameEntry("other", 344);
        GameEntry gameEntry4 = new GameEntry("other2", 235);

        Scoreboard scoreBoard = new Scoreboard(10);
        scoreBoard.add(gameEntry1);
        scoreBoard.add(gameEntry2);
        scoreBoard.add(gameEntry3);
        scoreBoard.add(gameEntry4);

        Arrays.stream(scoreBoard.getBoard()).forEach(System.out::println);

        scoreBoard.remove(1);
        Arrays.stream(scoreBoard.getBoard()).forEach(System.out::println);
    }

    public void add(GameEntry gameEntry) {
        int newScore = gameEntry.getScore();
        if (isValidHighScoreEntry(newScore)) {
            if (noOfEntries < board.length)
                noOfEntries++;
            int index = findIndexForNewScoreAndShiftEntries(newScore);
            board[index] = gameEntry;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= noOfEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        GameEntry gameEntry = board[i];
        removeGameEntry(i);
        return gameEntry;
    }

    private void removeGameEntry(int i) {
        for (int j = i; j < noOfEntries - 1; j++)
            board[j] = board[j + 1];
        board[noOfEntries - 1] = null;
        noOfEntries--;
    }

    private boolean isValidHighScoreEntry(int newScore) {
        return (noOfEntries < board.length) || (newScore > board[noOfEntries - 1].getScore());
    }

    private int findIndexForNewScoreAndShiftEntries(int newScore) {
        int j = noOfEntries - 1;
        while (j > 0 && board[j - 1].getScore() < newScore) {
            board[j] = board[j - 1];
            j--;
        }
        return j;
    }

    public GameEntry[] getBoard() {
        return board;
    }
}

class GameEntry {
    private final String name;
    private final int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "GameEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}