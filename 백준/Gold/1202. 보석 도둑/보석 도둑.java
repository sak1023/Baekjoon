import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jew implements Comparable<Jew> {
  int M;
  int V;

  public Jew(int M, int V) {
    this.M = M;
    this.V = V;
  }

  @Override
  public int compareTo(Jew o) {
    if (this.M == o.M) {
      return o.V - this.V;
    }

    return this.M - o.M;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Jew[] jew = new Jew[N];
    int[] C = new int[K];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int M = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());

      jew[i] = new Jew(M, V);
    }

    for (int i = 0; i < K; i++) {
      C[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(jew);
    Arrays.sort(C);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    long ans = 0;

    for (int i = 0, j = 0; i < K; i++) {
      while (j < N && jew[j].M <= C[i]) {
        pq.offer(jew[j++].V);
      }

      if (!pq.isEmpty()) {
        ans += pq.poll();
      }
    }

    System.out.print(ans);
  }
}
