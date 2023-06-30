import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static int N, Count = 0;
  public static int[] Board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    Board = new int[N];

    Chess_Queen(0);

    bw.write(Integer.toString(Count));
    bw.flush();
    bw.close();
  }

  public static void Chess_Queen(int Trials) {
    if (Trials == N) {
      Count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      Board[Trials] = i;

      Check_Queen(Trials);
    }
  }

  public static void Check_Queen(int Trials) {
    for (int i = 0; i < Trials; i++) {
      if (Board[i] == Board[Trials] ||
          Math.abs(i - Trials) == Math.abs(Board[i] - Board[Trials])) {
        return;
      }
    }

    Chess_Queen(Trials + 1);
  }
}