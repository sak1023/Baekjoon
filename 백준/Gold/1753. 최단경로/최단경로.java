import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node> {
    int e;
    int w;

    node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(node o) {
        return w - o.w;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        List<List<node>> graph = new ArrayList<>();
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(u).add(new node(v, e));
        }

        PriorityQueue<node> pq = new PriorityQueue<>();

        pq.add(new node(K, 0));

        while (!pq.isEmpty()) {
            node curNode = pq.remove();
            int s = curNode.e;

            if (visited[s]) {
                continue;
            }

            visited[s] = true;

            for (node n : graph.get(s)) {
                if (dist[n.e] > dist[s] + n.w) {
                    dist[n.e] = dist[s] + n.w;
                    pq.add(new node(n.e, dist[n.e]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}