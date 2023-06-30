import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter((new OutputStreamWriter((System.out))));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> POKEMON_book = new HashMap<String, Integer>();

    String[] POKEMON_name = new String[N + 1];

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= N; i++) {
      POKEMON_book.put(POKEMON_name[i] = br.readLine(), i);
    }

    while(M-- > 0) {
      String input = br.readLine();
      
      if (isNumber(input)) {
        sb.append(POKEMON_name[Integer.parseInt(input)] + "\n");
      } else {
        sb.append(POKEMON_book.get(input) + "\n");
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  public static boolean isNumber(String str) {
    try {
      Integer.parseInt(str);

      return true;
    }
    catch (NumberFormatException isNotNumber) {
      return false;
    }
  }
}