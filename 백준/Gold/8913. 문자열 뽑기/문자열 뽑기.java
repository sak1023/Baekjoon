import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<String>[] visited = new ArrayList[25];
    public static int str_len;
    public static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine().strip();
            int s_len = s.length();
            answer = false;

            for (int i = 0; i < 25; i++) {
                visited[i] = new ArrayList<>();
            }

            char com = s.charAt(0);

            for (int i = 1; i < s_len; i++) {
                if (answer) {
                    break;
                }
                char cur = s.charAt(i);

                int j = i;

                if (com == cur) {
                    while (com == cur && j++ < s_len - 1) {
                        cur = s.charAt(j);
                    }

                    Popping(s.substring(0, i - 1) + s.substring(j, s_len));

                    if (j < s_len - 1) {
                        com = s.charAt(j);
                    }

                    i = j;
                } else {
                    com = cur;
                }
            }

            if (answer) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void Popping(String str) {
        if (answer) {
            return;
        }

        int len = str.length();

        if (len == 0) {
            answer = true;
            return;
        }

        for (String i : visited[len]) {
            if (i.equals(str)) {
                return;
            }
        }

        char com = str.charAt(0);

        for (int i = 1; i < len; i++) {
            char cur = str.charAt(i);

            int j = i;

            if (com == cur) {
                while (com == cur && j++ < len - 1) {
                    cur = str.charAt(j);
                }

                String tmp = str.substring(0, i - 1) + str.substring(j, len);
                visited[len].add(tmp);
                Popping(tmp);

                if (j < len - 1) {
                    com = str.charAt(j);
                }

                i = j;
            } else {
                com = cur;
            }

        }
    }
}