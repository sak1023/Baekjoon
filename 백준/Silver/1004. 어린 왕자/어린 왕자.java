import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] Args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Integer T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      Integer[] point = new Integer[4];
      Integer count = 0;

      StringTokenizer st1 = new StringTokenizer(br.readLine());

      for (int i = 0; i < 4; i++) {
        point[i] = Integer.parseInt(st1.nextToken());
      }

      Integer n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        Integer[] planet = new Integer[3];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int j = 0; j < 3; j++) {
          planet[j] = Integer.parseInt(st2.nextToken());
        }

        if (Math.pow(point[0] - planet[0], 2) + Math.pow(point[1] - planet[1], 2) < Math.pow(planet[2], 2)
            && Math.pow(point[2] - planet[0], 2) + Math.pow(point[3] - planet[1], 2) > Math.pow(planet[2], 2)) {
          count++;
        } else if (Math.pow(point[0] - planet[0], 2) + Math.pow(point[1] - planet[1], 2) > Math.pow(planet[2], 2)
            && Math.pow(point[2] - planet[0], 2) + Math.pow(point[3] - planet[1], 2) < Math.pow(planet[2], 2)) {
          count++;
        }
      }
      bw.write(Integer.toString(count) + "\n");
    }
    bw.flush();
    bw.close();
  }
}