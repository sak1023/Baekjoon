import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[][] board;
  public static boolean[][] b;
  public static int b_cnt = 0, w_cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    board = new int[N][N];
    b = new boolean[N][N];

    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    b_bishop(0, 0);
    w_bishop(0, 0);

    System.out.print(b_cnt + w_cnt);
  }

  public static void b_bishop(int cnt, int y) {
    b_cnt = Math.max(b_cnt, cnt);
    for (int i = y; i < board.length; i++) {
      for (int j = i % 2; j < board.length; j += 2) {
        if (board[i][j] == 1 && b_isPossible(i, j)) {
          b[i][j] = true;
          b_bishop(cnt + 1, i);
          b[i][j] = false;
        }
      }
    }
  }

  public static void w_bishop(int cnt, int y) {
    w_cnt = Math.max(w_cnt, cnt);
    for (int i = y; i < board.length; i++) {
      for (int j = (i % 2) ^ 1; j < board.length; j += 2) {
        if (board[i][j] == 1 && w_isPossible(i, j)) {
          b[i][j] = true;
          w_bishop(cnt + 1, i);
          b[i][j] = false;
        }
      }
    }
  }

  public static boolean b_isPossible(int x, int y) {
    for (int i = 0; i < board.length; i++) {
      for (int j = i % 2; j < board.length; j += 2) {
        if (b[i][j] == true && (i + j == x + y || i - j == x - y)) {
          return false;
        }
        if (i == x && j == y) {
          break;
        }
      }
    }
    return true;
  }

  public static boolean w_isPossible(int x, int y) {
    for (int i = 0; i < board.length; i++) {
      for (int j = (i % 2) ^ 1; j < board.length; j += 2) {
        if (b[i][j] == true && (i + j == x + y || i - j == x - y)) {
          return false;
        }
        if (i == x && j == y) {
          break;
        }
      }
    }
    return true;
  }
}