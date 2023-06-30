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

    int a = 1, b = 1;

    StringBuilder sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0) {
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        break;
      } else if (b % a == 0) {
        sb.append("factor\n");
      } else if (a % b == 0) {
        sb.append("multiple\n");
      } else {
        sb.append("neither\n");
      }
    }
  }
}