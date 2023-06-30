import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] problem1_1 = new int[N];
        int[] problem1_2 = new int[N];
        int[] problem2 = new int[N];
        int answer1 = 0;
        int answer2 = 1;

        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            problem1_1[i] = str.charAt(i) - '0';
            problem1_2[i] = problem1_1[i];
        }

        str = br.readLine();
        for (int i = 0; i < N; i++) {
            problem2[i] = str.charAt(i) - '0';
        }

        for (int i = 1; i < N + 1; i++) {
            if (problem1_1[i - 1] != problem2[i - 1]) {
                for (int j = (i - 1 == N - 1 ? i - 2 : i - 1); j <= (i + 1 < N ? i + 1 : N - 1); j++) {
                    problem1_1[j] = problem1_1[j] == 0 ? 1 : 0;
                }
                answer1++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (problem1_1[i] != problem2[i]) {
                for (int j = 0; j < 2; j++) {
                    problem1_2[j] = problem1_2[j] == 0 ? 1 : 0;
                }
                answer1 = Integer.MAX_VALUE;
                break;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (problem1_2[i - 1] != problem2[i - 1]) {
                for (int j = (i - 1 == N - 1 ? i - 2 : i - 1); j <= (i + 1 < N ? i + 1 : N - 1); j++) {
                    problem1_2[j] = problem1_2[j] == 0 ? 1 : 0;
                }
                answer2++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (problem1_2[i] != problem2[i]) {
                bw.write("-1");
                bw.flush();
                bw.close();
                System.exit(0);
            }
        }

        bw.write(Integer.toString(Math.min(answer1, answer2)));
        bw.flush();
        bw.close();
    }
}