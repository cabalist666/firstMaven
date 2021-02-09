import edu.duke.*;
import org.apache.commons.csv.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.setRootFrame;
import static javax.swing.JOptionPane.showMessageDialog;

public class WhichCountriesExport {
    public static void listExporters(CSVParser parser, String exportOfInterest, String exportOfInterest2) {
        int count = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (exportOfInterest.length() > 0 && exportOfInterest2.length() > 0) {
                if (export.contains(exportOfInterest) && export.contains(exportOfInterest2)) {
                    System.out.println(record.get("Country"));
                }
            } else {
                if (export.contains(exportOfInterest)) {
                    System.out.println(record.get("Country"));
                    count++;
                }
            }
        }
        showMessageDialog(null, "已完成找尋" + exportOfInterest); // 如果沒有Frame，null會吃預設。
        System.out.println("Count = "+ count);
    }

public static void whoExportsSomething(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
     listExporters(parser,"gold","diamonds");
    // GetCountryInfo(parser,"Nauru");
    //GetEconomyIndexOnList(parser,1);
}

public static void GetCountryInfo(CSVParser parser,String CountryWantToFind){
    for (CSVRecord record : parser) {
        String export = record.get("Country");
        if (CountryWantToFind.length() > 0 && export.equals(CountryWantToFind)) {
                System.out.println("GetCountryInfo Answer");
                System.out.println(record.get("Exports"));
        }
    }
}

public static void GetEconomyIndexOnList(CSVParser parser,Integer indexOfList){
        ArrayList<Integer> ArrayValueList =new ArrayList<Integer>();
        ArrayList<String> NameOfCountry =new ArrayList<String>();
    for (CSVRecord record : parser) {
        String export = record.get("Value (dollars)");
        String afterRemove = export.substring(1);
        // 利用Regex正規表達式去處理。
        String regex  = "(?<=[\\d])(,)(?=[\\d])";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(afterRemove);
        afterRemove = m.replaceAll("");
        if(afterRemove.length() > 12){
            System.out.println(record.get("Country"));
        }
    }
    /* Sorting of arraylist using Collections.sort*/
    // Collections.sort(ArrayValueList);

}

public static void ShowInputDialog(){
    // 設定JFrame 和 JDialog 為 Swing主題風格，如無設定則會套用作業系統的外框樣式
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    // 設定frame的基本設定(如：標題、視窗大小、提示...等)
    JFrame frame = new JFrame("Show Input Dialog Demo");
    frame.setSize(400,300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    // 設定多種ShowinputDialog
    //// TextField範例
    String input = JOptionPane.showInputDialog("請輸入："); // showInputDialog最少要有一個參數，即顯示的提示文字，不需特別指定父容器，其預設為當前的父容器
    JOptionPane.showMessageDialog(frame, "您所輸入的是"+ input);
    JOptionPane.showInputDialog(frame, "請輸入","先測試看看會有什麼"); // 畫面上input欄位的預設值
    JOptionPane.showInputDialog(frame, "輸入的標題", JOptionPane.INFORMATION_MESSAGE);
    input = (String) JOptionPane.showInputDialog(frame, "請輸入：","輸入的標題", JOptionPane.QUESTION_MESSAGE, null,null,"放在文字方塊的內容");
    JOptionPane.showMessageDialog(frame,"您輸入的是"+input);
    //// ComboBox範例
    String[] strArrays = {"籃球","排球","羽毛球"};
    // 當於ComboBox的時候，其回傳值為Object物件，而非String，因此必須強制轉型成String才能再被使用
    String selectItem = (String) JOptionPane.showInputDialog(frame, "請選擇您喜好的球類：","喜好的球類",JOptionPane.PLAIN_MESSAGE,null,strArrays,"籃球");
    JOptionPane.showMessageDialog(frame,"您選擇的是"+selectItem);
    /// 設定關閉JFrame的狀態，Exit_on_close可以關閉視窗。
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

public static void ScannerUserInput(){
    //Scannner 不會有提示訊息，只有在畫面上的input。
    Scanner sc= new Scanner(System.in); //System.in is a standard input stream
    System.out.print("Enter a string: ");
    String str= sc.nextLine();              //reads string
    System.out.print("You have entered: "+str);
}

public static void main(String[] args) {
    whoExportsSomething();
    //ScannerUserInput();
    // dialog有包含input
    //ShowInputDialog();
}


}