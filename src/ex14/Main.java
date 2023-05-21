package ex14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // sa se simuleze jocul x si 0.
        char tabel[][] = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabel[i][j] = ' ';
            }
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introduceti i: ");
            int i = scanner.nextInt() - 1;
            System.out.println();
            System.out.print("Introduceti j: ");
            int j = scanner.nextInt() - 1;
            System.out.println();
            System.out.print("Introduceti x sau 0: ");
            char x0 = scanner.next().charAt(0);
            tabel[i][j] = x0;
            printTable(tabel);

            boolean resultLinie = checkLinie(tabel);
            if (resultLinie == true) {
                break;
            }
            boolean resultColoana = checkColoana(tabel);
            if (resultColoana) {
                break;
            }
            boolean resultDiagonalaPrincipala = checkDiagonalaPrincipala(tabel);
            if (resultDiagonalaPrincipala) {
                break;
            }
            boolean resultDiagonalaSecundara = checkDiagonalaSecundara(tabel);
            if (resultDiagonalaSecundara) {
                break;
            }
        }

    }

    public static boolean checkLinie(char tabel[][]) {
        for (int i = 0; i < 3; i++) {
            String line = "";
            for (int j = 0; j < 3; j++) {
                line = line + tabel[i][j];
            }
            if (line.equals("xxx") || line.equals("000")) {
                System.out.println("Avem un castigator!");
                return true;
            }
        }
        return false;
    }

    public static boolean checkColoana(char tabel[][]) {
        for (int i = 0; i < 3; i++) {
            String coloana = "";
            for (int j = 0; j < 3; j++) {
                coloana = coloana + tabel[j][i];
            }

            if (coloana.equals("xxx") || coloana.equals("000")) {
                System.out.println("Avem un castigator!");
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonalaPrincipala(char tabel[][]) {
        String diagonalaPrincipala = "";
        for (int i = 0; i < 3; i++) {
            diagonalaPrincipala = diagonalaPrincipala + tabel[i][i];
        }
        if (diagonalaPrincipala.equals("xxx") || diagonalaPrincipala.equals("000")) {
            System.out.println("Avem un castigator!");
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDiagonalaSecundara(char tabel[][]) {
        String diagonalaSecundara = "";
        for (int i = 0; i < 3; i++) {
            int j = 2 - i;
            diagonalaSecundara = diagonalaSecundara + tabel[i][j];
        }
        if (diagonalaSecundara.equals("xxx") || diagonalaSecundara.equals("000")) {
            System.out.println("Avem un castigator!");
            return true;
        } else {
            return false;
        }

    }

    public static void printTable(char tabel[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabel[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

}
