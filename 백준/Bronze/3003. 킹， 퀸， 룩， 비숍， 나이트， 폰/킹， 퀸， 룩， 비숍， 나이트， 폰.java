import java.util.Scanner;

public class Main {

  public static void main(String args[]){

    int[] Pieces1 = new int[6];
    int[] Pieces2 = {1, 1, 2, 2, 2, 8};

    Scanner scan = new Scanner(System.in);
    
    for(int i = 0; i < Pieces1.length; i++){
      Pieces1[i] = scan.nextInt();
      Pieces2[i] -= Pieces1[i];
      System.out.print(Pieces2[i] + " ");
    }
  }
}