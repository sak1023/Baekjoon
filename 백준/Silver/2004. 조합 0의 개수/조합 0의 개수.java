import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

    int Count_Div2 = 0;
    int Count_Div5 = 0;

    Count_Div2 += Div(n, 2);
    Count_Div2 -= Div(m, 2);
    Count_Div2 -= Div(n - m, 2);

    Count_Div5 += Div(n, 5);
    Count_Div5 -= Div(m, 5);
    Count_Div5 -= Div(n - m, 5);


    bw.write(Integer.toString(Math.min(Count_Div2, Count_Div5)));
    bw.flush();
    bw.close();
  }

  public static int Div(int Num1, int Num2) {
    int Count = 0;

    while (Num1 >= Num2) {
      Count += Num1 /= Num2;
    }

    return Count;
  }
}