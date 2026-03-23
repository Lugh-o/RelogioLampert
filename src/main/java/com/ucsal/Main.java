package com.ucsal;

public class Main {
    public static void main(String[] args) {

        Process p1 = new Process(8);
        Process p2 = new Process(6);

        int[][] messageMatrix = new int[8][6];

        messageMatrix[0][1] = 1;
        messageMatrix[1][2] = 1;
        messageMatrix[2][3] = 1;

        messageMatrix[3][1] = -1;
        messageMatrix[4][2] = -1;

        messageMatrix[5][4] = 1;
        messageMatrix[6][5] = 1;

        messageMatrix[7][3] = -1;

        LamportClock.printMatrix(messageMatrix, p1.events.length, p2.events.length);

        LamportClock.compute(p1, p2, messageMatrix);
        LamportClock.print(p1, p2);
    }
}