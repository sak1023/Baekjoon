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
        int trim = Get_Round(n * 0.15);
        double sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for (int i = trim; i < n - trim; i++) {
            sum += nums[i];
        }

        bw.write(Integer.toString(Get_Round(sum / (n - trim * 2))));
        bw.flush();
        bw.close();
    }

    private static int Get_Round(double d) {
        return d - (int) d >= 0.5 ? (int) d + 1 : (int) d;
    }
}