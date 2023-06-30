import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class point {
    int r;
    int c;

    point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    public static int N, M, home_size, chicken_size, answer = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static ArrayList<point> home = new ArrayList<>();
    public static ArrayList<point> chicken = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur_st = Integer.parseInt(st.nextToken());

                if (cur_st == 1) {
                    home.add(new point(i, j));
                } else if (cur_st == 2) {
                    chicken.add(new point(i, j));
                }
            }
        }

        home_size = home.size();
        chicken_size = chicken.size();

        visited = new boolean[chicken_size];

        get_town_dist(0, 0);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void get_town_dist(int idx, int depth) {
        if (depth == M) {
            int[] dist = new int[home_size];

            Arrays.fill(dist, Integer.MAX_VALUE);
    
            for (int i = 0; i < home_size; i++) {
                point h = home.get(i);
                for (int j = 0; j < chicken_size; j++) {
                    if (visited[j] == false) {
                        continue;
                    }

                    point ch = chicken.get(j);
                    dist[i] = Math.min(dist[i], Math.abs(h.r - ch.r) + Math.abs(h.c - ch.c));
                }
            }

            int tmp = 0;
    
            for (int i = 0; i < dist.length; i++) {
                tmp += dist[i];
            }
            answer = Math.min(answer, tmp);

            return;
        }

        for (int i = idx; i < chicken_size; i++) {
            visited[i] = true;
            get_town_dist(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}