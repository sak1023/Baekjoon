import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class node {
    int end;
    int weight;

    public node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    public static List<List<node>> road;
    public static int[] dist;
    public static int N;
    public static final int INF = 5_000_000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            road = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                road.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                road.get(S).add(new node(E, T));
                road.get(E).add(new node(S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                road.get(S).add(new node(E, -T));
            }
            sb.append(isMinusCycle() ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isMinusCycle() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update;

        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (node e : road.get(j)) {
                    if (dist[e.end] > dist[j] + e.weight) {
                        dist[e.end] = dist[j] + e.weight;
                        update = true;
                    }
                }
            }

            if (!update) {
                return false;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (node e : road.get(i)) {
                if (dist[e.end] > dist[i] + e.weight) {
                    return true;
                }
            }
        }
        return false;
    }
}