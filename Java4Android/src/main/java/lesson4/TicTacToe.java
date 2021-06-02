package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static int SIZE;
    static int WIN_MATCH;
    static char[][] MAP;

    private static final String EMPTY = " ";
    private static final String HEADER_FIRST_SYMBOL = "♥";

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    //lastTurn/startPos  - 1 значение строка, 2 значение столбец
    static int[] lastTurn = new int[2];
    static int[] startPos = new int[2];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static int turnsCount = 0;


    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {
        do {
            setProperty();
            initMap();
            printMap();
            playGame();
        } while (endGame());
    }

    private static void setProperty() {
        while (true) {
            System.out.println("Введите размер поля от 3 до 10");
            if (in.hasNextInt()) {
                int size = in.nextInt();
                if (size >= 3 && size <= 10) {
                    SIZE = size;
                    setWinMatch();
                    System.out.println("Размер поля будет установлен: " + SIZE + ", выигрышная комбинация состоит из " + WIN_MATCH + " знаков");
                    MAP = new char[SIZE][SIZE];
                    break;
                }
            }
        }
    }

    private static void setWinMatch() {
        switch (SIZE) {
            case 3:
            case 4:
                WIN_MATCH = 3;
                break;
            default:
                WIN_MATCH = 4;
                break;
        }
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print((SIZE == 10) ? HEADER_FIRST_SYMBOL + EMPTY + EMPTY : HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i, "header");
        }
        System.out.println();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i, "body");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i, String mod) {
        if (mod == "body") {
            System.out.print((SIZE == 10) ? ((i != 9) ? i + 1 + EMPTY + EMPTY : i + 1 + EMPTY) : i + 1 + EMPTY);
        } else {
            System.out.print(i + 1 + EMPTY);
        }
    }


    private static void playGame() {

        do {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        } while (true);

    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;
        boolean isInputValid;

        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            colNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбец: ");
            if (in.hasNextInt()) {
                colNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanTurnValid(rowNumber, colNumber)));

        lastTurn[0] = rowNumber;
        lastTurn[1] = colNumber;
        MAP[rowNumber][colNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void processingIncorrectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне игрового поля");
        in.next();
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (!isNumberValid(rowNumber, colNumber)) {
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        }
        if (!isCellFree(rowNumber, colNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }
        return true;
    }

    private static boolean isNumberValid(int rowNumber, int colNumber) {
        return rowNumber < SIZE && rowNumber >= 0 && colNumber < SIZE && colNumber >= 0;
    }

    private static boolean isCellFree(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }


    private static boolean checkEnd(char symbol) {

        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко... ИИ победил");
            }
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {
        return  (horizon(symbol) || vertical(symbol) || mainDiagonal(symbol) || sideDiagonal(symbol));
    }

    private static boolean horizon(char symbol) {
        //Проверяем горизонталь
        int matches = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[lastTurn[0]][i] == symbol) {
                matches++;
            } else {
                matches = 0;
            }
            if (matches == WIN_MATCH) return true;
        }
        return false;
    }

    private static boolean vertical(char symbol) {
        //Проверяем вертикаль
        int matches = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][lastTurn[1]] == symbol) {
                matches++;
            } else {
                matches = 0;
            }
            if (matches == WIN_MATCH) return true;
        }
        return false;
    }

    private static boolean mainDiagonal(char symbol) {
        //Проверяем главную диагональ
        //Находим стартовую ячейку
        setStartPos(startPos, lastTurn[0], lastTurn[1]);
        while(true) {
            if (startPos[0] == 0 || startPos[1] == 0) {
                break;
            } else {
                startPos[0]--;
                startPos[1]--;
            }
        }
        //Проверяем
        int matches = 0;
        do {
            if (MAP[startPos[0]][startPos[1]] == symbol) {
                matches++;
            } else {
                matches = 0;
            }
            if (matches == WIN_MATCH) return true;
            startPos[0]++;
            startPos[1]++;
        } while (startPos[0] < SIZE && startPos[1] < SIZE);
        return false;
    }

    private static boolean sideDiagonal(char symbol) {
        //Проверяем побочную диагональ
        //Находим стартовую ячейку
        setStartPos(startPos, lastTurn[0], lastTurn[1]);
        while(true) {
            if (startPos[0] == SIZE - 1 || startPos[1] == 0) {
                break;
            } else {
                startPos[0]++;
                startPos[1]--;
            }
        }
        //Проверяем
        int matches = 0;
        do {
            if (MAP[startPos[0]][startPos[1]] == symbol) {
                matches++;
            } else {
                matches = 0;
            }
            if (matches == WIN_MATCH) return true;
            startPos[0]--;
            startPos[1]++;
        } while (startPos[0] > -1 && startPos[1] < SIZE);
        return false;
    }

    private static void setStartPos(int[] startPos, int i, int i2) {
        startPos[0] = i;
        startPos[1] = i2;
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод компуктера");
        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, colNumber));
        MAP[rowNumber][colNumber] = DOT_AI;
        turnsCount++;
    }

    private static boolean endGame() {
        System.out.println("Сыграете еще раз? y/n");
        if (in.next().equals("y") || in.next().equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
