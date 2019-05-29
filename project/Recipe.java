import java.util.Scanner;
import java.util.ArrayList;
/**
*
* Recipe Creator and Manager
*/
public class Recipe {
   
   private String emriIRecetes;
   private double kaloritERecetesNeTotal;
   private ArrayList<String> perberesitERecetes;
   private int sherbimi;
   
   public Recipe() {
      this.emriIRecetes = "";
      this.sherbimi = 0;
      this.perberesitERecetes =  new ArrayList<>();
      this.kaloritERecetesNeTotal = 0;       
   }
    
   public Recipe(String emriIRecetes, int sherbimi,
        ArrayList<String> perberesitERecetes, double kaloritERecetesNeTotal)
   {
      this.emriIRecetes = emriIRecetes;
      this.sherbimi = sherbimi;
      this.perberesitERecetes = perberesitERecetes;
      this.kaloritERecetesNeTotal = kaloritERecetesNeTotal;
   }
   
   public String getEmriIRecetes() {
      return emriIRecetes;
   }

   public void setEmriIRecetes(String emriIRecetes) {
      this.emriIRecetes = emriIRecetes;
   }

   public double getKaloritERecetesNeTotal() {
      return kaloritERecetesNeTotal;
   }

   public void setKaloritERecetesNeTotal(double kaloritERecetesNeTotal) {
      this.kaloritERecetesNeTotal = kaloritERecetesNeTotal;
   }

   public ArrayList<String> getPerberesitERecetes() {
      return perberesitERecetes;
   }

   public void setPerberesitERecetes(ArrayList<String> perberesitERecetes) {
      this.perberesitERecetes = perberesitERecetes;
   }

   public int getSherbimi() {
      return sherbimi;
   }

   public void setSherbimi(int sherbimi) {
      this.sherbimi = sherbimi;
   }

   public void printRecipe() {
      int kaloritVetemTeSherbimit = (int) (kaloritERecetesNeTotal/sherbimi);
   	
      System.out.println("Recete: " + emriIRecetes);
      System.out.println("sherben: " + sherbimi);
      System.out.println("perberesit:");
      for(String perberes: perberesitERecetes) {
         System.out.println(perberes);
      }
      System.out.println("Qdo sherbim ka " + kaloritVetemTeSherbimit + " Kalori.");
   }
   
   
   public static void main(String[] args) {
      double kaloritERecetesNeTotal = 0;
      ArrayList<String> perberesitERecetes = new ArrayList<String>();
      boolean addMorePerberes = true;
       
      Scanner scnr = new Scanner(System.in);
       
      System.out.println("Ju lutemi shkruani emrin e recetes: ");
      String emriIRecetes = scnr.nextLine();
       
      System.out.println("Ju lutemi shkruani numrin e sherbimit: ");
      int sherbimi = scnr.nextInt();
       
               
      do {
         System.out.println("Ju lutemi shkruani emrin e perberesit"
            +" ose shenoni fund nese ju keni perfunduar perberesit: ");
         String emriIPerberesit = scnr.next();
       
         if (emriIPerberesit.toLowerCase().equals("fund")) {
            addMorePerberes = false;
         } else {
            perberesitERecetes.add(emriIPerberesit);
            	
            System.out.println("Ju lutemi shkruani shumen e perberesit: ");
            float shumaEPerberesit = scnr.nextFloat();
           
            System.out.println("Ju lutemi shkruani kalorite e perberesit: ");
            int kaloriteEPerberesit = scnr.nextInt();
               
            kaloritERecetesNeTotal += (kaloriteEPerberesit * shumaEPerberesit);           
         }          
      } while(addMorePerberes);
       
      Recipe recipe = new Recipe(emriIRecetes,
            sherbimi, perberesitERecetes, kaloritERecetesNeTotal);
      recipe.printRecipe();
        
      scnr.close();
   }
}