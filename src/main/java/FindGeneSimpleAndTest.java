/*
 * Find the Gene of the DNA
 *
 * @Henry Shih
 * @Version 1.0
 */
public class FindGeneSimpleAndTest {

    public static String findGeneSimple(String dna){
        // start codon is "ATG";
        // stop codon is "TAA";
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf("TAA",startIndex+3);
        // 要包含TAA
        if(endIndex == -1){
            return "";
        }
        result = dna.substring(startIndex,endIndex+3);
        if((endIndex-startIndex)%3 == 0) {
            return result;
        } else{
            return "";
        }
    }

    public static void main(String[] args){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);
    }
}
