package Week2;

public class FindGeneWhile {
    public String findGene(String dna){
        //Find fist occurrence of "ATG"
        int startIndex = dna.indexOf("ATG");
        //Find the "TAA" starting from (startIndex + 3)
        int currIndex = dna.indexOf("TAA",startIndex + 3);
        //As long as currIndex is not equal -1

        while(currIndex != -1){
            //Check if (currIndex - startIndex) is a multiple of 3
            if((currIndex - startIndex) % 3 == 0){
                // if so, the text between startIndex and currIndex + 3 is your answer
                return dna.substring(startIndex, currIndex + 3);
            }
            //if not, update currIndex to the index of the next TAA, starting from currIndex + 1
            else{
                currIndex = dna.indexOf("TAA",currIndex + 1);
            }
        } return "NOT FOUND";
    }



    public void testFindGeneSimple1(){
        String dna = "0ATG00TAA0TAA000";
        System.out.println("DNA stand is " + dna);
        String gene = findGene(dna);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        dna = "0000ATG0TAA0000TAA000000TAA";
        System.out.println("DNA stand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        dna = "LLLATGLLLLLLTAA";
        /**
         * DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
         */
        System.out.println("DNA stand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        System.out.println("======");

        //dna = "AATGCTAGGGTAATATGGT";
        dna = "LATGLLLLlTAA";
        /**
         * DNA with ATG, TAA and the substring between them is NOT a multiple of 3
         */
        System.out.println("DNA stand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        System.out.println("======");

//        dna = "LLLLLTAA";
//        /**
//         *  DNA with no “ATG”
//         */
//        System.out.println("DNA stand is " + dna);
//        gene = findGene(dna);
//        System.out.println("Gene is " + gene);
//        System.out.println("======");
//
//        //dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
//        dna = "ATGLLLLLL";
//        /**
//         * DNA with no “TAA”
//         */
//        System.out.println("DNA stand is " + dna);
//        gene = findGene(dna);
//        System.out.println("Gene is " + gene);
//
//        //dna = "ATGTAA";
//        dna = "LLLLLLLL";
//        /**
//         * DNA with no “ATG” or “TAA”
//         */
//        System.out.println("DNA stand is " + dna);
//        gene = findGene(dna);
//        System.out.println("Gene is " + gene);
    }
    public static void main(String[] args) {
        FindGeneWhile findGeneWhile = new FindGeneWhile();
        findGeneWhile.testFindGeneSimple1();
    }
}
