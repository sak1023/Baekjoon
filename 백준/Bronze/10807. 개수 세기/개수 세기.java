import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer analy = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (N-- > 0) {
            if (analy == Integer.parseInt(st.nextToken())) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}