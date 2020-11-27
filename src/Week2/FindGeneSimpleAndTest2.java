package Week2;

public class FindGeneSimpleAndTest2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        /**
         * Start codon is "ATG"
         * Stop codon is "TAA"
         */

        String result = "";

        if(dna.matches(".*[a-z].*")){
            dna = dna.toLowerCase();
            int startIndex = dna.indexOf(startCodon.toLowerCase());
            int stopIndex = dna.indexOf(stopCodon.toLowerCase(),startIndex+3);
            if(stopIndex == -1 && startIndex == -1){
                return "There's no ATG and TAA";
            }
            else if(startIndex == -1){
                return "There's no ATG";
            }
            else if(stopIndex == -1){
                return "There's no TAA";
            }
            result = dna.substring(startIndex, stopIndex + 3);
            if(result.length() % 3 == 0){
                return result;
            }

            return "It's not a gene";

        } else if(dna.matches(".*[A-Z].*")){
            dna = dna.toUpperCase();
            int startIndex = dna.indexOf(startCodon);
            int stopIndex = dna.indexOf(stopCodon,startIndex+3);


            if(stopIndex == -1 && startIndex == -1){
                return "There's no ATG and TAA";
            }
            else if(startIndex == -1){
                return "There's no ATG";
            }
            else if(stopIndex == -1){
                return "There's no TAA";
            }
            result = dna.substring(startIndex, stopIndex + 3);
            if(result.length() % 3 == 0){
                return result;
            }

            return "It's not a gene";
        }
        return "Error";
    }

    public void testSimpleGene(){
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String dna = "LLLATGLLLLLLTAA"; // между ними должны делиться на 3 типа 3,6,9,12,15.....
        /**
         * DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
         */
        System.out.println("DNA stand is " + dna);
        String gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        //dna = "AATGCTAGGGTAATATGGT";
        dna = "LATGLLLLlTAA";
        /**
         * DNA with ATG, TAA and the substring between them is NOT a multiple of 3
         */
        System.out.println("DNA stand is " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        dna = "LLLLLTAA";
        /**
         *  DNA with no “ATG”
         */
        System.out.println("DNA stand is " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        //dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        dna = "ATGLLLLLL";
        /**
         * DNA with no “TAA”
         */
        System.out.println("DNA stand is " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        //dna = "ATGTAA";
        dna = "LLLLLLLL";
        /**
         * DNA with no “ATG” or “TAA”
         */
        System.out.println("DNA stand is " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        dna = "atgllltaa";
        System.out.println("DNA stand is " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);

    }

    public static void main(String[] args) {
        FindGeneSimpleAndTest2 findGeneSimpleAndTest2 = new FindGeneSimpleAndTest2();
        findGeneSimpleAndTest2.testSimpleGene();
    }
}
