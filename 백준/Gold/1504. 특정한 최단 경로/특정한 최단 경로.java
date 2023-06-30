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
    public static List<List<node>> graph = new ArrayList<>();
    public static int[] weights;
    public static PriorityQueue<node> pq = new PriorityQueue<>();
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new node(b, c));
            graph.get(b).add(new node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        weights = new int[N + 1];
        int answer1 = 0;
        int answer2 = 0;

        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, N);
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, N);

        if (answer1 >= 200000000 && answer2 >= 200000000) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(Math.min(answer1, answer2)));
        }
        bw.flush();
        bw.close();
    }

    public static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(weights, 200000000);
        weights[start] = 0;
        pq.add(new node(start, 0));

        while (!pq.isEmpty()) {
            node curNode = pq.remove();
            int s = curNode.e;

            visited[s] = true;

            for (node e : graph.get(s)) {
                if (visited[e.e] || weights[e.e] <= weights[s] + e.w) {
                    continue;
                }
                weights[e.e] = weights[s] + e.w;
                pq.add(new node(e.e, weights[e.e]));
            }
        }
        return weights[end];
    }
}