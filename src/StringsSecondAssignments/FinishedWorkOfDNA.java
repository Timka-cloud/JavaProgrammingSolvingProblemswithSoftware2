package StringsSecondAssignments;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class FinishedWorkOfDNA {
    /**
     * Start codon is "ATG"
     * Stop codon is "TAA"
     * -1 it means in method indexOf that not found the text
     */
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        //find StopCodon starting from (startIndex + 3)
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        // as long as currIndex is not equal to -1
         while(currIndex != - 1){
             //check if currIndex - startIndex is a multiple of 3;
             //if so, currIndex is answer, return it
             int diff = currIndex - startIndex;
             if(diff % 3 == 0){
                 return currIndex;
             }
             // if not update currIndex, looking for stopCodon
             // starting from currIndex + 1
             else{
                 currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
             }
         } return -1;
    }

    public String findGene(String dna, int where){
        // find first occurrence of "ATG", startIndex
        int startIndex = dna.indexOf("ATG", where);
        //if startIndex is -1, return ""
        if(startIndex == -1){
            return "";
        }
        //StopCodon can end "TAA" "TAG" "TGA"
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        // find the smallest of these three variables
        int minIndex = 0;
        if(taaIndex == -1 || tagIndex != -1 && tagIndex < taaIndex){
            minIndex = tagIndex;
        } else {
            minIndex = taaIndex;
        }
        if(minIndex == -1 || tgaIndex != -1 && tgaIndex < minIndex){
            minIndex = tgaIndex;
        }// if -1 is the smallest return ""
        if(minIndex == -1){
            return "";
        }
       // otherwise answer is text from startIndex to minIndex
        return dna.substring(startIndex,minIndex + 3);

    }

    public StorageResource getAllGenes(String dna){
        //create StorageResource from edu.duke.StorageResource;
        StorageResource geneList = new StorageResource();
        // set startIndex to 0;
        int startIndex = 0;
        while(true){
            //Find the next gene after StartIndex
            String currentGene = findGene(dna, startIndex);
            // if no gene was found, leave the loop
            if(currentGene.isEmpty()){
                break;
            }
//            System.out.println(currentGene);
            // передать все гены в StorageResource
            geneList.add(currentGene);
            // Set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }

    public void test(String dna){

        StorageResource genes = getAllGenes(dna);
        for(String s : genes.data()){
            System.out.println(s);
        }

        System.out.println("-----------");
        processGenes(genes,dna);




    }

    public float cgRatio (String dna){
        // find "C" and "G" in the gene and (float) (countC+ countG)/ dna.length();
        int indexC = dna.indexOf("C");
        int countC = 0;
        while( indexC != -1) {
            countC +=1;
            indexC=dna.indexOf("C", indexC + 1);
        }
        int indexG = dna.indexOf("G");
        int countG = 0;
        while( indexG != -1) {
            countG +=1;
            indexG=dna.indexOf("G", indexG + 1);
        }

        return (float) (countC+ countG)/ dna.length();
    }


    public void testFindGeneSimple1() {
        // it's various DNA for testing
        FileResource fr = new FileResource("cg.text");
        String dna = fr.asString();
        String dna1 = dna.toUpperCase();
        System.out.println("DNA stand is " + dna1);

        int count = countGenes(dna1);
        System.out.println("DNA is " + count);
        test(dna1);

//        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
//
//        System.out.println("DNA stand is " + dna);
//        test(dna);

//        System.out.println("======");
//
//       dna = "000000TAA0TAA000";  //TAA
//        System.out.println("DNA stand is " + dna);
//        test(dna);
//        count = countGenes(dna);
//        System.out.println("DNA is " + count);
//        System.out.println("======");
//
//
//        dna = "000ATG00TAG0TAA00ATG000TAG00ATG0000TAA00TGA000"; //TAG
//        System.out.println("DNA stand is " + dna);
//        test(dna);
//        count = countGenes(dna);
//        System.out.println("DNA is " + count);
//        System.out.println("======");
//
//
//        dna = "AATGCTAACTAGCTGACTAAT";
//        System.out.println("DNA stand is " + dna);
//        test(dna);
//        count = countGenes(dna);
//        System.out.println("DNA is " + count);
//        System.out.println("======");
//
//        dna = "ATGTAA";
//        System.out.println("DNA stand is " + dna);
//        test(dna);
//        count = countGenes(dna);
//        System.out.println("DNA is " + count);
//        System.out.println("======");


    }

    public void processGenes(StorageResource sr,String dna){
        // check gene is more 9 character or not and if more than count them
        int count = 0;
        for(String s : sr.data()){
            String temp = s;

            if(temp.length() >= 9){
                count++;
                System.out.println("9 character or more: " + temp.length());

            } else{
                System.out.println("Less than 9 character");
            }


        }

        System.out.println("9 or more character is: " + count);


// check if "C" and "G" more or less 0.35 and count them if more
        int count1 = 0;
        for(String f : sr.data()){

            if(cgRatio(f) > 0.35){
                count1++;
//                System.out.println("C'G " + f);
            }
        }
        System.out.println("cgRatio count is " + count1);


        // Find the maximum length from all genes
        int max = 0;
        for(String s : sr.data()){
            String big = s;
            if(max < big.length()){
                max = big.length();
            }
        }
        System.out.println("The maximum is: " + max);

    }



    public int countGenes(String dna){
        //Here I count the genes
        int startIndex = 0;
        int count = 0;
        while(true){
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            count++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return count;
    }

    public static void main(String[] args) {
        FinishedWorkOfDNA part1 = new FinishedWorkOfDNA();
        part1.testFindGeneSimple1();



    }
}
