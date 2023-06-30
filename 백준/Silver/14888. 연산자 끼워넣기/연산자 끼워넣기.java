import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static int[] Nums;
  public static int[] O = new int[4];
  public static int N, Max = -1000000000, Min = 1000000000;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    Nums = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      Nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      O[i] = Integer.parseInt(st.nextToken());
    }

    Calculate(Nums[0], 0);

    bw.write(Integer.toString(Max) + "\n" + Integer.toString(Min));
    bw.flush();
    bw.close();
  }
  
  public static void Calculate(int Result, int Trials) {
    if (Trials == N - 1) {
      Max = Math.max(Result, Max);
      Min = Math.min(Result, Min);
      return;
    }

    for (int i = 0; i < 4; i++) {

      if (O[i] > 0) {
        O[i]--;

        switch (i) {
          case 0 : Calculate(Result + Nums[Trials + 1], Trials + 1);
          break;

          case 1 : Calculate(Result - Nums[Trials + 1], Trials + 1);
          break;

          case 2 : Calculate(Result * Nums[Trials + 1], Trials + 1);
          break;

          case 3 : Calculate(Result / Nums[Trials + 1], Trials + 1);
          break;
        }

        O[i]++;
      }
    }
  }
}