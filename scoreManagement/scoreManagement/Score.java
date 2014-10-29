package scoreManagement;

import java.io.Serializable;

public class Score implements Serializable{
String score[];
  
  public Score(String name, String kor, String eng, String math) {
    
    score = new String[6];
    score[0] = name;
    score[1] = kor;
    score[2] = eng;
    score[3] = math;
    //sum
     score[4] = String.valueOf(
         Integer.parseInt(score[1])
         +Integer.parseInt(score[2])
         +Integer.parseInt(score[3])
         );
     
    //avg
      score[5] = String.valueOf((Integer.parseInt(score[4])/3));
  }
}
