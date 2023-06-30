import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class recursive_function {
  String str0 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
  String str1 = "\"재귀함수가 뭔가요?\"";
  String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
  String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
  String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
  String str5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
  String str6 = "라고 답변하였지.";
  String under = "____";
  int count;

  StringBuilder sb = new StringBuilder();
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

  void print() throws IOException {
    sb.append(str0 + "\n" + str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n");
    recursive(1);
    sb.append(str6 + "\n");

    bw.write(sb + "\n");
    bw.flush();
    bw.close();
  }

  void recursive(int N)  {
    if(N < count)  {
      sb.append(under.repeat(N) + str1 + "\n" + under.repeat(N) + str2 + "\n" + under.repeat(N) + str3 + "\n" + under.repeat(N) + str4 + "\n");
      
      recursive(N + 1);
    }

    else if(N == count)  {
      sb.append(under.repeat(N) + str1 + "\n" + under.repeat(N) + str5 + "\n");
    }

    sb.append(under.repeat(N) + str6 + "\n");
  }
}

public class Main {  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    recursive_function N = new recursive_function();

    N.count = Integer.parseInt(br.readLine());
    N.print();
  }
}