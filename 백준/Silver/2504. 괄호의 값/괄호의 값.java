import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static Stack<Character> s = new Stack<>();
    public static int p_cnt = 0, b_cnt = 0, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == ')') {
                p_cnt++;
            } else if (c == ']') {
                b_cnt++;
            }

            s.add(line.charAt(i));
        }

        while (!s.isEmpty()) {
            char c = s.pop();

            if (c == ')') {
                answer += parenthesis();
            } else if (c == ']') {
                answer += brace();
            } else if (c == '(') {
                if (--p_cnt < 0) {
                    end();
                }
                answer *= 2;
            } else {
                if (--b_cnt < 0) {
                    end();
                }
                answer *= 3;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static int parenthesis() {
        if (s.isEmpty()) {
            end();
        }

        if (s.peek() == '(') {
            if (--p_cnt < 0) {
                end();
            }
            s.pop();
            return 2;
        }

        int result = 0;

        while (s.peek() != '(') {
            char n = s.pop();

            if (n == ')') {
                result += parenthesis();
            } else if (n == ']') {
                result += brace();
            } else if (n == '(') {
                if (--p_cnt < 0) {
                    end();
                }
                result *= 2;
            } else {
                if (--b_cnt < 0) {
                    end();
                }
                result *= 3;
            }

            if (s.isEmpty()) {
                end();
            }
        }

        s.pop();

        return result * 2;
    }

    public static int brace() {
        if (s.isEmpty()) {
            end();
        }

        if (s.peek() == '[') {
            if (--b_cnt < 0) {
                end();
            }
            s.pop();
            return 3;
        }

        if (s.isEmpty()) {
            end();
        }

        int result = 0;

        while (s.peek() != '[') {
            char n = s.pop();

            if (n == ')') {
                result += parenthesis();
            } else if (n == ']') {
                result += brace();
            } else if (n == '(') {
                if (--p_cnt < 0) {
                    end();
                }
                result *= 2;
            } else {
                if (--b_cnt < 0) {
                    end();
                }
                result *= 3;
            }

            if (s.isEmpty()) {
                end();
            }
        }

        s.pop();

        return result * 3;
    }

    public static void end() {
        System.out.println(0);
        System.exit(0);
    }
}