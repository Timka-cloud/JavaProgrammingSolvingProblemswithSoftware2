public class Main {

    public static void main(String[] args) {

        System.out.println(doCompare());


    }

    public static String doCompare(){
        String endCodon = "TAA";
        String endCodon2 = "ZZZ";
        String gene;
        String dna = "0ATGZZZTAA0ZZZ000";
        System.out.println("DNA stand is " + dna);
        String gene2 = find(dna,endCodon);
        String gene1 = find(dna,endCodon2);
        if(endCodon.indexOf(dna) > endCodon2.indexOf(dna)){
           return gene = endCodon2;

        } else return gene = endCodon;



    }


    public static String find(String dna, String endCodon){
            String f = endCodon;
            //Find fist occurrence of "ATG"
            int startIndex = dna.indexOf("ATG");
            //Find the "TAA" starting from (startIndex + 3)
            int currIndex = dna.indexOf(f,startIndex + 3);
            //As long as currIndex is not equal -1

            while(currIndex != -1){
                //Check if (currIndex - startIndex) is a multiple of 3
                if((currIndex - startIndex) % 3 == 0){
                    // if so, the text between startIndex and currIndex + 3 is your answer
                    return f;
                }
                //if not, update currIndex to the index of the next TAA, starting from currIndex + 1
                else{
                    currIndex = dna.indexOf(f,currIndex + 1);
                }
            } return f;
        }



}
