import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] Args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr1 = new int[N];
    StringTokenizer st1 = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr1[i] = Integer.parseInt(st1.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    int[] arr2 = new int[M];
    StringTokenizer st2 = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      arr2[i] = Integer.parseInt(st2.nextToken());
    }

    Arrays.sort(arr1);

    StringBuilder sb = new StringBuilder();

    for (int i : arr2) {
      sb.append(bi_search(arr1, i) + " ");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  public static int bi_search(int[] arr, int num) {
    int count = 0;
    int L = 0;
    int R = arr.length - 1;

    while (L <= R) {
      int M = (L + R) / 2;

      if (arr[M] == num) {
        count = upper(arr, M) - lower(arr, M) - 1;

        break;
      } else if (arr[M] > num) {
        R = M - 1;
      } else {
        L = M + 1;
      }
    }

    return count;
  }

  public static int lower(int[] arr, int num) {
    int L = 0;
    int R = num - 1;

    if (R == -1) {
      return -1;
    }

    if (arr[R] != arr[num]) {
      return R;
    }

    while (L <= R) {
      int M = (L + R) / 2;

      if (arr[M] < arr[num]) {
        L = M + 1;
      } else {
        R = M - 1;
      }
    }

    return R;
  }

  public static int upper(int[] arr, int num) {
    int L = num + 1;
    int R = arr.length - 1;

    if (L == arr.length) {
      return arr.length;
    }

    if (arr[L] != arr[num]) {
      return L;
    }

    while (L <= R) {
      int M = (L + R) / 2;

      if (arr[M] > arr[num]) {
        R = M - 1;
      } else {
        L = M + 1;
      }
    }

    return L;
  }
}