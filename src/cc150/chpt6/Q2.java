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
public class Q2 {

    public static class Robot {
        public static final int N = 10;
        int gridWidth = N;
        int gridHeight = N;
        public static int moveCount = 0;
        public static LinkedList<Move> path = new LinkedList<Move>();

        public Robot(int gridWidth, int gridHeight) {
            this.gridWidth = gridWidth;
            this.gridHeight = gridHeight;
        }


        public void moveToNext() {
            Robot nextStep1 = new Robot(gridWidth, gridHeight);
            boolean movedRight = nextStep1.move(Move.RIGHT);
            if (movedRight) {
                Robot.path.addLast(Move.RIGHT);
                Robot.moveCount++;
                nextStep1.moveToNext();
            }

            Robot nextStep2 = new Robot(gridWidth, gridHeight);
            boolean movedDown = nextStep2.move(Move.DOWN);
            if (movedDown) {
                Robot.path.addLast(Move.DOWN);
                Robot.moveCount++;
                nextStep2.moveToNext();
            }

        }

        public boolean move(Move move) {
            switch (move) {
                case RIGHT:
                    gridWidth--;
                    if (gridWidth <= 0) return false;
                    return true;
                case DOWN:
                    gridHeight--;
                    if (gridHeight <= 0) return false;
                    return true;
            }
            return false;
        }

        static enum Move {
            RIGHT, DOWN
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot(Robot.N, Robot.N);
        robot.moveToNext();
        System.out.println(robot.moveCount);
    }


}
