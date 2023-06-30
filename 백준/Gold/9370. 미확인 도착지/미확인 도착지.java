import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] graph;
    public static int[] dist;
    public static int n;
    public static int MAX_VALUE = 50000 * 1000 + 1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());                // 테스트 케이스

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());               // 교차로 개수
            int m = Integer.parseInt(st.nextToken());           // 도로 개수
            int t = Integer.parseInt(st.nextToken());           // 목적지 후보 개수

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());           // 출발지
            int g = Integer.parseInt(st.nextToken());           // 경유지 1
            int h = Integer.parseInt(st.nextToken());           // 경유지 2

            graph = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(graph[i], MAX_VALUE * 2);
            }

            while(m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());       // 교차로 1
                int b = Integer.parseInt(st.nextToken());       // 교차로 2
                int d = Integer.parseInt(st.nextToken());       // 교차로 1과 교차로 2 사이의 양방향 도로 길이

                d *= 2;

                graph[a][b] = d;
                graph[b][a] = d;
            }
            graph[g][h] = graph[h][g] -=1;

            int[] x_case = new int[t];

            for (int i = 0; i < t; i++) {
                x_case[i] = Integer.parseInt(br.readLine());    // 목적지 후보
            }

            Arrays.sort(x_case);
            dijkstra(s);

            for (int x : x_case) {
                if (dist[x] % 2 == 1) {
                    sb.append(x + " ");
                }
            }
            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }
        bw.flush();
        bw.close();
    }

    public static int[] dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        boolean[] visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, MAX_VALUE * 2);
        dist[s] = 0;
        
        pq.add(new int[] {s, 0});
        while(!pq.isEmpty()) {
            int[] curNode = pq.remove();
            int start = curNode[0];

            if (visited[start]) {
                continue;
            }

            visited[start] = true;

            for (int end = 1; end <= n; end++) {
                if (visited[end]) {
                    continue;
                }
                if (dist[end] > dist[start] + graph[start][end]) {
                    dist[end] = dist[start] + graph[start][end];
                    pq.add(new int[] {end, dist[end]});
                }
            }
        }
        return dist;
    }
}