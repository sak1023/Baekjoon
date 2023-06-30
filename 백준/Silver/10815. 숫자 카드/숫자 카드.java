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
    int N = Integer.parseInt(br.readLine());
    int[] card = new int[N];
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    StringBuilder result = new StringBuilder();
    
    for (int i = 0; i < N; i++) {
      card[i] = Integer.parseInt(st1.nextToken());
    }

    Arrays.sort(card);
    
    while (M-- > 0) {
      if (Arrays.binarySearch(card, Integer.parseInt(st2.nextToken())) >= 0) {
        result.append("1 ");
      } else {
        result.append("0 ");
      }
    }

    bw.write(result.toString());
    bw.flush();
    bw.close();
  }
}