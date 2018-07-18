package com.company;

import java.util.Scanner;

public class Main {

    static final char CROSS = 'x';
    static final char CIRCLE = 'o';
    static final char EMPTY = '-';
    static int circleCount = 0;
    static int crossCount = 0;

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
//        Выбор, за какую сторону играет игрок - крестик, или нолик
        int playerNumber;
        while (true) {
            System.out.println("Крестик - 1, нолик - 2");
            playerNumber = in.nextInt();
            if (playerNumber == 1 || playerNumber == 2) break;
        }

//        Заполнение массива значениями по умолчанию и вывод его на экран
        char[][] table = new char[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = EMPTY;
            }
            System.out.println();
        }

        while (true) {
            table = setCoordinates(playerNumber, table);
            if (playerNumber == 1) playerNumber = 2;
            else playerNumber = 1;
        }

//        while (true){
//
//        }


    }

    static private char[][] setCoordinates(int playerNumber, char[][] table) {
        Scanner in = new Scanner(System.in);
        int coordinateI;
        int coordinateJ;
        System.out.println("Игрок " + playerNumber);
        System.out.println("Введите координату i = ");
        coordinateI = in.nextInt();
        System.out.println("Введите координату j = ");
        coordinateJ = in.nextInt();


        if (table[coordinateI][coordinateJ] == EMPTY) {
            if (playerNumber == 1) {
                table[coordinateI][coordinateJ] = CROSS;
            } else if (playerNumber == 2) {
                table[coordinateI][coordinateJ] = CIRCLE;
            }
        }

        getCoordinates(table);

        if (table[coordinateI][coordinateJ] != -1) {
            if (coordinateI == 0 && coordinateJ == 0) {
                if (table[coordinateI][coordinateJ] == table[coordinateI + 1][coordinateJ + 1] && table[coordinateI + 1][coordinateJ + 1] == table[coordinateI + 2][coordinateJ + 2]) {
                    System.out.println("Winner is player number : " + playerNumber);
                    System.exit(1);
                    return table;
                }
            }
        } else if (coordinateI == coordinateJ) {
            if (table[coordinateI - 1][coordinateJ - 1] == table[coordinateI][coordinateJ] && table[coordinateI][coordinateJ] == table[coordinateI + 1][coordinateJ + 1]) {
                System.out.println("Winner is player number : " + playerNumber);
                System.exit(1);
                return table;
            }
        } else if ((table[coordinateI][0] == table[coordinateI][1] && table[coordinateI][1] == table[coordinateI][2]) ||
                (table[0][coordinateJ] == table[1][coordinateJ] && table[1][coordinateJ] == table[2][coordinateJ])) {
            System.out.println("Winner is player number : " + playerNumber);
            System.exit(1);
            return table;


        }
        return table;
    }

    static private void getCoordinates(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

    }
}
