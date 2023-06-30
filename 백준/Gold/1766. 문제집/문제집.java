import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] indegree = new int[N + 1];
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<>());
    }

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      list.get(A).add(B);
      indegree[B]++;
    }

    System.out.println(Solve(indegree, list));
  }

  public static String Solve(int[] indegree, List<List<Integer>> list) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        pq.offer(i);
      }
    }

    while(!pq.isEmpty()) {
      int rootnode = pq.poll();

      sb.append(rootnode + " ");

      for (int i : list.get(rootnode)) {
        indegree[i]--;

        if (indegree[i] == 0) {
          pq.offer(i);
        }
      }
    }
    
    return sb.toString();
  }
}