import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];

    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        board[r][c] = '-';
      }
    }

    System.out.println("Let's play TTT!!");

    movePlayer(board);

  }

  public static void drawBoard(char[][] board) {
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        System.out.print(board[r][c] + " ");
      }
      System.out.println(); // new line
    }
  }

  public static void movePlayer(char[][]board) {
    Scanner inp = new Scanner(System.in);

    int row;
    int col;
    boolean playerOne = true;

    while (true) {
      drawBoard(board);

      System.out.print("Enter a row number (0, 1, or 2): ");
      row = inp.nextInt();

      System.out.print("Enter a column number (0, 1, or 2): ");
      col = inp.nextInt();

      if (board[row][col] != '-') {
        System.out.println("That spot is taken!");
        continue;
      }

      if (playerOne) {
        board[row][col] = 'x';
        evaluateWin(board);
        playerOne = false;
      } else {
        board[row][col] = 'o';
        evaluateWin(board);
        playerOne = true;
      }

    }
  }

  public static void evaluateWin(char[][] board) {

    // evaluate rows
    for (int r = 0; r < 3; r++) {
      if (board[r][0] == '-') break;
      for (int c = 1; c < 3; c++) {
        if (board[r][c] != board[r][c-1]) break;
        if (c >= 2) System.out.println("we have a winner!");
      }

    }
  }

  
}

// C C C
// R - - -
// R - - -
// R - - -

// 3x3 board

// loop
// person 1 or 2
// Choose a row (1,2 or 3)?
// Choose a column (1, 2 or 3)?
// Is the location empty?

// win??
// row
// col
// diag
// if no moves remaining and no winner (aka, "cat"), then exit
// end loop
