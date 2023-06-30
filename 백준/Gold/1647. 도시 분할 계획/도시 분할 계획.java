import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class house implements Comparable<house> {
  int A;
  int B;
  int C;

  public house(int A, int B, int C) {
    this.A = A;
    this.B = B;
    this.C = C;
  }

  @Override
  public int compareTo(house o) {
    return this.C - o.C;
  }
}

public class Main {
  public static List<house> list = new ArrayList<>();
  public static int[] chk;
  public static int sum = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    chk = new int[N];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken()) - 1;
      int B = Integer.parseInt(st.nextToken()) - 1;
      int C = Integer.parseInt(st.nextToken());

      list.add(new house(A, B, C));
    }

    for (int i = 0; i < N; i++) {
      chk[i] = i;
    }

    Collections.sort(list);

    MST();

    System.out.print(sum);

  }

  public static void MST() {
    int cnt = 0;

    for (int i = 0; i < list.size(); i++) {
      if (cnt == chk.length - 2) {
        return;
      }

      house tmp = list.get(i);

      if (union(tmp.A, tmp.B)) {
        sum += tmp.C;
        cnt++;
      }
    }
  }

  public static boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      chk[y] = x;
      return true;
    }
    return false;
  }

  public static int find(int x) {
    if (chk[x] == x) {
      return x;
    }

    return chk[x] = find(chk[x]);
    }
}