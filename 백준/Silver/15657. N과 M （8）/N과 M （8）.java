import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] nums;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            chocolate_ball(Integer.toString(nums[i]) + " ", nums[i], 1);
        }
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void chocolate_ball(String str, int num, int depth) {
        if (depth == M) {
            sb.append(str + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            int cur = nums[i];
            if (num <= cur) {
                chocolate_ball(str + nums[i] + " ", cur, depth + 1);
            }    
        }
    }
}