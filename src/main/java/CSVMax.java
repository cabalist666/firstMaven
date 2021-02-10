
import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.*;

import java.io.File;

public class CSVMax {

    public static CSVRecord hottestHourInfile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow: parser){
            largestSoFar = getLargestOfTwo(currentRow,largestSoFar);
        }
        return largestSoFar;
    }

    public static CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        // 可以選多個檔案
        DirectoryResource dr = new DirectoryResource();
        // 找每個檔案
        for(File f: dr.selectedFiles()){
            FileResource fr =  new FileResource(f);
            CSVRecord currentRow = hottestHourInfile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow,largestSoFar);
        }
        return largestSoFar;

    }

    public static CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
        if(largestSoFar == null){
            largestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if(currentTemp > largestTemp){
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public static void testHottestInDay(){
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord largest = hottestHourInfile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at "+ largest.get("TimeEST"));
    }

    public static void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at "+ largest.get("DateUTC"));
    }

    public static void main(String[] args) {
        // testHottestInDay();
        testHottestInManyDays();
    }
}
