/*기남*/
package scoreManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class mainProject {

  public static void main(String[] args) throws Exception {

    ArrayList<Score> list = new ArrayList<Score>();
    
    
    try{
      
    BufferedReader in = new BufferedReader(new FileReader("score.dat"));
    while(true){
     String line[] = in.readLine().split(",");
     if(line.length<3) break;
    list.add(new Score(line[0],line[1],line[2],line[3]));
    }
    }catch(Exception e){
      
    }
    
    
    
    while (true) {
        
      System.out.print("\n명령>");
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      String arr[] = input.split(" ");

      switch (arr[0]) {

      
      
      
      case "help":
        System.out.println("list");
        System.out.println("view 인덱스");
        System.out.println("add 이름 국어 영어 수학");
        System.out.println("delete 인덱스");
        System.out.println("update 인덱스");
        System.out.println("exit");
        break;

        
        
        
      case "add":
        list.add(new Score(arr[1], arr[2], arr[3], arr[4]));
        System.out.println("저장되었습니다.");
        break;

        
        
        
      case "list":
        for (int i = 0; i < list.size(); i++) {
          System.out.print(" " + i);
          for (int j = 0; j < 4; j++) {
            System.out.print(" " + list.get(i).score[j]);
          }
          System.out.println();
        }
        break;

        
        
        
      case "delete":

        if (Integer.parseInt(arr[1]) < list.size()) {

          System.out.print(list.get(Integer.parseInt(arr[1])).score[0]
              + "를 삭제하시겠습니까? y/n : ");
          if (scanner.next().equals("y")) {
            list.remove(Integer.parseInt(arr[1]));
            System.out.println("삭제하였습니다.");
          } else {
            System.out.println("삭제취소하였습니다.");
          }
        } else {
          System.out.println("존재하지 않는 인덱스입니다.");
        }
        break;

        
        
        
      case "view":
        String[] scoreName = { "이름", "국어", "영어", "수학" };
        System.out.println("인덱스: " + Integer.parseInt(arr[1]));
        for (int i = 0; i < 4; i++) {
          System.out.println(scoreName[i] + " : "
              + list.get(Integer.parseInt(arr[1])).score[i]);
        }
        System.out
            .println("합계 : " + list.get(Integer.parseInt(arr[1])).score[4]);
        System.out
            .println("평균 : " + list.get(Integer.parseInt(arr[1])).score[5]);

        break;

        
        
        
        
      case "update":
        String[] uN = { "이름", "국어", "영어", "수학" };

        for (int i = 0; i < 4; i++) {
          System.out.print(uN[i]+" : "+list.get(Integer.parseInt(arr[1])).score[i] + " => ");
          input = scanner.nextLine();
          if (input.equals("")) {
            uN[i] = list.get(Integer.parseInt(arr[1])).score[i];
          } else {
            uN[i] = input;
          }
        }
        System.out.print("정말 변경하시겠습니까? y/n : ");
        if (scanner.next().equals("y")) {
          list.set(Integer.parseInt(arr[1]),
              new Score(uN[0], uN[1], uN[2], uN[3]));
          System.out.println("변경되었습니다.");
        } else {
          System.out.println("변경취소하였습니다.");
        }
        break;

        
        
        
      case "exit":
        BufferedWriter out = new BufferedWriter(new FileWriter("score.dat"));
 //       ObjectOutputStream out2 = new ObjectOutputStream(out);
         for(int i=0;i<list.size();i++){
             for(int j=0;j<4;j++){
               String line = list.get(i).score[j];
               out.write(line);
               if(j<3) {  out.write(",");}
               }
             out.newLine();
           }
         
         
        out.close();
        return;

      default:
        System.out.println("잘못된 명령어입니다.");
        break;
      }
    }
  }
}
