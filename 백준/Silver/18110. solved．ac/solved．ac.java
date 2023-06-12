import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int trim = (int) Math.round(n * 0.15);
        double sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for (int i = trim; i < n - trim; i++) {
            sum += nums[i];
        }

        bw.write(Integer.toString((int) Math.round(sum / (n - trim * 2))));
        bw.flush();
        bw.close();
    }
}