import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node> {
    int end;
    int weight;

    public node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(node o) {
        return weight - o.weight;
    }
}

public class Main {
    public static List<List<node>> bus;
    public static int N;
    public static final int INF = 100_000_000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        bus = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            bus.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            bus.get(s).add(new node(e, w));
        }

        st = new StringTokenizer(br.readLine());

        bw.write(Integer.toString(dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
        bw.flush();
        bw.close();
    }
    public static int dijkstra(int s, int e) {
        boolean[] visited = new boolean[N + 1];
    
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(s, 0));

        while(!pq.isEmpty()) {
            node curNode = pq.remove();
            int start = curNode.end;

            if (visited[start]) {
                continue;
            }
            visited[start] = true;

            for (node end : bus.get(start)) {
                if (!visited[end.end] && dist[end.end] > dist[start] + end.weight) {
                    dist[end.end] = dist[start] + end.weight;
                    pq.add(new node(end.end, dist[end.end]));
                }
            }
        }

        return dist[e];
    }
}