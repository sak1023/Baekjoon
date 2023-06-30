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

  public static void main(String[] args) throws IOException {
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer ST = new StringTokenizer(BR.readLine());
    N = Integer.parseInt(ST.nextToken());
    M = Integer.parseInt(ST.nextToken());

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
        if (Count == 0) {
          Temp.append(i + 1 + " ");
          Sequence(Count + 1);
          Temp.delete(Count * 2, M * 2);
        } else if (Temp.charAt(Count * 2 - 2) - '1' <= i) {
          Temp.append(i + 1 + " ");
          Sequence(Count + 1);
          Temp.delete(Count * 2, M * 2);
        }
      }
    }
  }
}