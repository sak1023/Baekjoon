import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static StringBuilder SB = new StringBuilder();
  public static StringBuilder Temp = new StringBuilder();
  public static int N, M;
  public static boolean[] Check;

  public static void main(String[] args) throws IOException {
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer ST = new StringTokenizer(BR.readLine());
    N = Integer.parseInt(ST.nextToken());
    M = Integer.parseInt(ST.nextToken());
    Check = new boolean[N];

    Sequence(0);

    BW.write(SB.toString());
    BW.flush();
    BW.close();
  }

  public static void Sequence(int Count) {
    if (Count == M) {
      SB.append(Temp + "\n");
    } else {
      for (int i = 0; i < N; i++) {
        if (!Check[i]) {
          Temp.append(i + 1 + " ");
          for (int j = 0; j < i + 1; j++) {
            Check[j] = true;
          }
          Sequence(Count + 1);
          for (int j = 0; j < i + 1; j++) {
            Check[j] = false;
          }
          Temp.delete(Count * 2, M * 2);
        }
      }
    }
  }
}