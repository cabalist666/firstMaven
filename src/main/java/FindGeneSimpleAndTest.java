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
        boolean OutFlag = false;
        int startIndex = dna.indexOf("ATG");
        int CurrentIndex = startIndex;
        while(!OutFlag){
        if(startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf("TAA",CurrentIndex+3);
        // 要包含TAA
        if(endIndex == -1){
            return "";
        }
        if((endIndex-startIndex)%3 == 0) {
            OutFlag = true;
            result = dna.substring(startIndex,endIndex+3);
        } else{
            CurrentIndex =  endIndex;
            //return "";
        }
        }
        return result;
    }

    public static void main(String[] args){
        String dna = "AATGCGATAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);

        String dna1 = "ATGATCGCTAATAATTAAGCT";
        System.out.println("DNA strand is " + dna1);
        String gene1 = findGeneSimple(dna1);
        System.out.println("Gene is "+ gene1);
    }
}
