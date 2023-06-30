import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] R = new int[N];
    int GCD;

    StringTokenizer st = new StringTokenizer(br.readLine());
    R[0] = Integer.parseInt(st.nextToken());

    for (int i = 1; i < N; i++) {
      R[i] = Integer.parseInt(st.nextToken());

      GCD = Get_GCD(R[0], R[i]);

      sb.append(Integer.toString(R[0] / GCD) + "/" + Integer.toString(R[i] / GCD) + "\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
  public static int Get_GCD(int Num1, int Num2) {
    if (Num1 % Num2 == 0) {
      return Num2;
    } else {
      return Get_GCD(Num2, Num1 % Num2);
    }
  }
}