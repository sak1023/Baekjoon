import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String[] S = new String[N];
    String[] check = new String[M];

    int count = 0;

    for (int i = 0; i < N; i++) {
      S[i] = br.readLine();
    }
    
    Arrays.sort(S);

    for (int i = 0; i < M; i++) {
      if (Arrays.binarySearch(S, br.readLine()) >= 0) {
        count ++;
      }
    }

    bw.write(Integer.toString(count));
    bw.flush();
    bw.close();
  }
}