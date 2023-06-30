import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int ans = Prime_Case(Prime_Num(N), N);
    
    System.out.print(ans);
  }

  public static List<Integer> Prime_Num(int N) {
    boolean[] isprime = new boolean[N + 1];
    List<Integer> prime = new ArrayList<>();

    int mul;

    for (int i = 2; i <= Math.sqrt(N); i++) {
      if (!isprime[i]) {
        mul = 2;
        while (i * mul <= N) {
          isprime[i * mul] = true;
          mul++;
        }
      }
    }

    for (int i = 2; i <= N; i++) {
      if (!isprime[i]) {
        prime.add(i);
      }
    }

    return prime;
  }

  public static int Prime_Case(List<Integer> prime, int N) {
    int cnt = 0, s = 0, sum;

    while (s <= prime.size() - 1) {
      sum = 0;
      for (int i = s; i < prime.size() && sum < N; i++) {
        sum += prime.get(i);
      }
      if (sum == N) {
        cnt++;
      }
      s++;
    }
   
    return cnt;
  }
}