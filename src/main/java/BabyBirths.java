import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

public class BabyBirths {
    public static void printNames(){
        // 會選檔案並開啟。
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100){
                System.out.println("Name " + rec.get(0) + " Gender "+ rec.get(1) + " Num Born" + rec.get(2));
            }
        }
    }

    public static void totalBirths(FileResource fr){
        int totalBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
        }
        System.out.println("total Births = "+totalBirths);
    }

    public static void main(String[] args) {
        //printNames();
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
}
