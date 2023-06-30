import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static double min;
  public static int[][] point;
  public static boolean[] chk;

  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            min = Double.MAX_VALUE;
            point = new int[N][2];
            chk = new boolean[N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                point[j][0] = Integer.parseInt(st.nextToken());
                point[j][1] = Integer.parseInt(st.nextToken());
            }

            C(0, N / 2);

            sb.append(min + "\n");
        }

        System.out.print(sb.toString());
    }

    public static void C(int N, int cnt) {
      if (cnt == 0) {
        min = Math.min(min, Vector());
        return;
      }

      for (int i = N; i < point.length; i++) {
        chk[i] = true;
        C(i + 1, cnt - 1);
        chk[i] = false;
      }
    }

    public static double Vector() {
      int x = 0, y = 0;

      for (int i = 0; i < point.length; i++) {
        if (chk[i]) {
          x += point[i][0];
          y += point[i][1];
        } else {
          x -= point[i][0];
          y -= point[i][1];
        }
      }

      return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}