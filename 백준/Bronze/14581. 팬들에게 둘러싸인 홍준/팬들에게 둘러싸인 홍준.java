import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(":fan::fan::fan:");
        System.out.print(":fan:");
        System.out.print(":" + str + ":");
        System.out.println(":fan:");
        System.out.print(":fan::fan::fan:");
    }
}