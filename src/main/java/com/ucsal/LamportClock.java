package com.ucsal;

public class LamportClock {

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static void compute(Process p1, Process p2, int[][] messageMatrix) {
        int e1 = p1.events.length;
        int e2 = p2.events.length;

        boolean updated;

        do {
            updated = false;

            for (int i = 0; i < e1; i++) {
                for (int j = 0; j < e2; j++) {

                    if (messageMatrix[i][j] == 1) {
                        int newValue = max(p2.events[j].timestamp, p1.events[i].timestamp + 1);

                        if (newValue != p2.events[j].timestamp) {
                            p2.events[j].timestamp = newValue;
                            updated = true;
                        }
                    }

                    if (messageMatrix[i][j] == -1) {
                        int newValue = max(p1.events[i].timestamp, p2.events[j].timestamp + 1);

                        if (newValue != p1.events[i].timestamp) {
                            p1.events[i].timestamp = newValue;
                            updated = true;
                        }
                    }
                }
            }

        } while (updated);
    }

    public static void print(Process p1, Process p2) {
        System.out.println("\nProcesso 1:");
        for (Event e : p1.events) {
            System.out.print(e.timestamp + " ");
        }

        System.out.println("\nProcesso 2:");
        for (Event e : p2.events) {
            System.out.print(e.timestamp + " ");
        }
    }

    public static void printMatrix(int[][] matrix, int e1, int e2) {
        System.out.print("\t");
        for (int j = 0; j < e2; j++) {
            System.out.print("P2_E" + (j + 1) + "\t");
        }

        for (int i = 0; i < e1; i++) {
            System.out.print("\nP1_E" + (i + 1) + "\t");
            for (int j = 0; j < e2; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
        }

        System.out.println("\n");
    }
}

