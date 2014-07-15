package cc150.chpt6;

import java.util.LinkedList;

/**
 * 6.2 Imagine a robot sitting on the upper left hand corner of an NxN grid.
 * The robot can only move in two directions: right and down. How many possible paths are there for the robot?
 * FOLLOW-UP
 * Imagine certain squares are “off limits”, such that the robot can not step on them. Design
 * an algorithm to print all possible paths for the robot.
 * Created by zhengxiao on 7/13/14.
 */
public class Q2S2 {

    static enum Move {
        RIGHT, DOWN
    }

    public static final int N = 2;

    public static int moveCount = 0;

    public static void main(String[] args) {
        move(N, N, new LinkedList<Move>());
        System.out.println(moveCount);
    }

    /**
     * 障碍
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean isFree(int x, int y) {
        return true;
//        return !(x == 1 && y == 1);
    }

    public static void move(int gridWidth, int gridHeight, LinkedList<Move> moves) {
        if (gridWidth == 0 && gridHeight == 0) {
            System.out.println(moves);
            moveCount++;
            return;
        }
        // right
        int newWidth = gridWidth - 1;
        if (newWidth >= 0 && isFree(newWidth, gridHeight)) {
            // success
            LinkedList<Move> movedRight = new LinkedList<Move>(moves);
            movedRight.add(Move.RIGHT);
            move(newWidth, gridHeight, movedRight);
        }

        // down
        int newHeight = gridHeight - 1;
        if (newHeight >= 0 && isFree(gridWidth, newHeight)) {
            // success
            LinkedList<Move> movedDown = new LinkedList<Move>(moves);
            movedDown.add(Move.DOWN);
            move(gridWidth, newHeight, movedDown);
        }
    }
}
