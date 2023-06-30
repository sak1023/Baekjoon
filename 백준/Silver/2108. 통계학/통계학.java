import java.io.*;
import java.util.*;

public class Main {
  public static void main(String Args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int[] values = new int[N];
    int sum = 0;

    for (int i = 0; i < N; i++) {
      values[i] = Integer.parseInt(br.readLine());
      sum += values[i];
    }

    Arrays.sort(values);

    bw.write(String.valueOf(arith_mean(sum, N)) + "\n");
    bw.write(String.valueOf(median(values, N)) + "\n");
    bw.write(String.valueOf(mode(values, N)) + "\n");
    bw.write(String.valueOf(range(values, N)));
    bw.flush();
    bw.close();
  }

  static long arith_mean(int sum, int N) {
    long result = Math.round((double) sum / (double) N);
    return result;
  }

  static int median(int[] values, int N) {
    if (N != 1) {
      return values[(N - 1) / 2];
    } else {
      return values[0];
    }
  }

  static int mode(int[] values, int N) {
    int count = 0;
    int max = 0;
    List<String> number = new ArrayList<String>();

    if (N != 1) {
      for (int i = 0; i < N - 1; i++) {

        if (values[i] == values[i + 1]) {
          count += 1;
          if (max < count) {
            max += 1;
            number.clear();
            if (number.indexOf(String.valueOf(values[i])) == -1) {
              number.add(String.valueOf(values[i]));
            }
          } else if (max == count) {
            if (number.indexOf(String.valueOf(values[i])) == -1) {
              number.add(String.valueOf(values[i]));
            }
          } else {
            if (max == count) {
              if (number.indexOf(String.valueOf(values[i])) == -1) {
                number.add(String.valueOf(values[i]));
              }
            }
          }
        } else {
          if (count == max) {
            if (number.indexOf(String.valueOf(values[i])) == -1) {
              number.add(String.valueOf(values[i]));
            }
          }
          count = 0;
        }
      }
      if (number.size() <= 1) {
        return Integer.parseInt(number.get(0));
      } else {
        return Integer.parseInt(number.get(1));
      }
    } else {
      return values[0];
    }
  }

  static int range(int[] values, int N) {
    Arrays.sort(values);
    return values[N - 1] - values[0];
  }
}