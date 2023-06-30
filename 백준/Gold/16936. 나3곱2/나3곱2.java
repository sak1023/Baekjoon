import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static Long[] seq;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        seq = new Long[N];
        visited = new boolean[N];
        int cnt = 0;

        for (String num : br.readLine().split(" ")) {
            seq[cnt++] = Long.parseLong(num);
        }

        for (int i = 0; i < N; i++) {
            BackTracking(i, new ArrayList<>(Arrays.asList(seq[i])));
        }
    }

    public static void BackTracking(int n, ArrayList<Long> list) {
        if (list.size() == N) {
            for (Long i : list) {
                System.out.print(i + " ");
            }
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                make_clone(i, n, list);
            }
        }

        for (int i = n + 1; i < N; i++) {
            if (!visited[i]) {
                make_clone(i, n, list);
            }
        }
    }

    public static void make_clone(int i, int n, ArrayList<Long> list) {
        Long cur_num = seq[n];
        Long nxt_num = seq[i];

        if (cur_num * 2 == nxt_num) {
            visited[i] = true;
            list.add(list.indexOf(cur_num) + 1, nxt_num);
            BackTracking(i, list);
            visited[i] = false;
        } else if (cur_num == nxt_num * 3) {
            visited[i] = true;
            list.add(list.indexOf(cur_num) + 1, nxt_num);
            BackTracking(i, list);
            visited[i] = false;
        }
    }
}