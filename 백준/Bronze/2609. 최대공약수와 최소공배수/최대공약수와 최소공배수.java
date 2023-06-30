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

    int Num1, Num2;

    StringTokenizer st = new StringTokenizer(br.readLine());

    Num1 = Integer.parseInt(st.nextToken());
    Num2 = Integer.parseInt(st.nextToken());

    int Divisor = 0;

    int[] Answer = new int[2];

    if (Num1 == Num2) {
      Divisor = Num1;
    } else if (Num1 > Num2) {
      for (int i = 1; i <= Num1 / 2; i++) {
        if (Num1 % i == 0 && Num2 % i == 0) {
          Divisor = i;
        }
      }
    } else {
      for (int i = 1; i <= Num2 / 2; i++) {
        if (Num1 % i == 0 && Num2 % i == 0) {
          Divisor = i;
        }
      }
    }

    Answer[0] = Divisor;
    Answer[1] = Num1 * Num2 / Answer[0];

    bw.write(Integer.toString(Divisor) + "\n" + Integer.toString(Num1 * Num2 / Divisor));
    bw.flush();
    bw.close();
  }
}