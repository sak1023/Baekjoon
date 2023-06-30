import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] Args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st1 = new StringTokenizer(br.readLine());

    int W = Integer.parseInt(st1.nextToken());
    int H = Integer.parseInt(st1.nextToken());
    int X = Integer.parseInt(st1.nextToken());
    int Y = Integer.parseInt(st1.nextToken());
    int P = Integer.parseInt(st1.nextToken());
    int count = 0;

    while (P-- > 0) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());

      int P_X = Integer.parseInt(st2.nextToken());
      int P_Y = Integer.parseInt(st2.nextToken());

      if (Y <= P_Y && P_Y <= Y + H) {
        if (X <= P_X && P_X <= X + W) {
          count++;
        } else if (P_X <= X && Math.pow(P_X - X, 2) + Math.pow(P_Y - (Y + H / 2), 2) <= Math.pow(H / 2, 2)) {
          count++;
        } else if (X + W <= P_X && Math.pow(P_X - (X + W), 2) + Math.pow(P_Y - (Y + H / 2), 2) <= Math.pow(H / 2, 2)) {
          count++;
        }
      }
    }

    bw.write(Integer.toString(count));
    bw.flush();
    bw.close();
  }
}