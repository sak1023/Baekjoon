import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class VE implements Comparable<VE> {
  int V;
  int E;
  int value;

  public VE(int V, int E, int value) {
    this.V = V;
    this.E = E;
    this.value = value;
  }

  @Override
  public int compareTo(VE o) {
    return this.value - o.value;
  }
}

public class Main {
  public static int sum = 0;
  public static int[] chk;
  public static ArrayList<VE> list = new ArrayList<VE>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    chk = new int[V];

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken()) - 1;
      int B = Integer.parseInt(st.nextToken()) - 1;
      int C = Integer.parseInt(st.nextToken());

      list.add(new VE(A, B, C));
    }

    for (int i = 0; i < V; i++) {
      chk[i] = i;
    }

    Collections.sort(list);

    MST();

    System.out.print(sum);
  }

  public static void MST() {

    for (int i = 0; i < list.size(); i++) {
      VE tmp = list.get(i);

      if (find(tmp.V) != find(tmp.E)) {
        sum += tmp.value;

        union(tmp.V, tmp.E);
      }
    }
  }

  public static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      chk[y] = x;
    }
  }

  public static int find(int x) {
    if (chk[x] == x) {
      return x;
    }

    return chk[x] = find(chk[x]);
  }
}