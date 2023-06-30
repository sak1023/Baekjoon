import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int[][] Sudoku = new int[9][9];
  public static List<int[]> Blank = new ArrayList<>();
  public static StringBuilder sb = new StringBuilder();

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        Sudoku[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (Sudoku[i][j] == 0) {
          Blank.add(new int[] {i, j});
        }
      }
    }

    Find_Zero(0);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(Sudoku[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.print(sb.toString());
  }

  public static boolean Find_Zero(int Trials) {
    if (Trials == Blank.size()) {
      return true;
    }

    int a = Blank.get(Trials)[0], b = Blank.get(Trials)[1];

    for (int i = 1; i <= 9; i++) {
      if (Fill_Zero(a, b, i)) {
        Sudoku[a][b] = i;
        if (Find_Zero(Trials + 1)) {
          return true;
        } else {
          Sudoku[a][b] = 0;
        }
      }
    }
    return false;
  }

  public static boolean Fill_Zero(int Num1, int Num2, int Num) {
    for (int i = 0; i < 9; i++) {
      if (Sudoku[Num1][i] == Num) {
        return false;
      } else if (Sudoku[i][Num2] == Num) {
        return false;
      }
    }

    for (int i = Num1 - Num1 % 3; i < Num1 - Num1 % 3 + 3; i++) {
      for (int j = Num2 - Num2 % 3; j < Num2 - Num2 % 3 + 3; j++) {
        if (Sudoku[i][j] == Num) {
          return false;
        }
      }
    }
    return true;
  }
}