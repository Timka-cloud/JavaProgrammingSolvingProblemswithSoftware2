package Week2;

public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna){
        /**
         * Start codon is "ATG"
         * Stop codon is "TAA"
         */

        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA",startIndex+3);

        if(stopIndex == -1 && startIndex == -1){
            return "There's no gene";
        }
        else if(startIndex == -1){
            return "There's no ATG";
        }
        else if(stopIndex == -1){
            return "There's no  TAA";
        }
        result = dna.substring(startIndex, stopIndex + 3);
        if(result.length() % 3 == 0){
            return result;
        }
        return "It's not a gene";
    }

    public void testFindGeneSimple(){
        String dna = "LLLATGLLLLLLTAA";
        /**
         * DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
         */
        System.out.println("DNA stand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        //dna = "AATGCTAGGGTAATATGGT";
        dna = "LATGLLLLlTAA";
        /**
         * DNA with ATG, TAA and the substring between them is NOT a multiple of 3
         */
        System.out.println("DNA stand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        dna = "LLLLLTAA";
        /**
         *  DNA with no “ATG”
         */
        System.out.println("DNA stand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        //dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        dna = "ATGLLLLLL";
        /**
         * DNA with no “TAA”
         */
        System.out.println("DNA stand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        //dna = "ATGTAA";
        dna = "LLLLLLLL";
        /**
         * DNA with no “ATG” or “TAA”
         */
        System.out.println("DNA stand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
    }

    public static void main(String[] args) {
        FindGeneSimpleAndTest findGeneSimpleAndTest = new FindGeneSimpleAndTest();
        findGeneSimpleAndTest.testFindGeneSimple();
    }
}
