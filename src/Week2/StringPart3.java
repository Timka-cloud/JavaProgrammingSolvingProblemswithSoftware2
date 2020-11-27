package Week2;

public class StringPart3 {
    public boolean twoOccurrences(String stringA,String stringB){
        int start = stringB.indexOf(stringA);
        int next = stringB.indexOf(stringA,start+1);
        if(start == -1 || next == -1){
            return false;
        }
        return true;
    }

    public String lastPart(String stringA,String stringB){
        int word = stringB.indexOf(stringA);

        if(word == -1){
            return stringB;
        }
        int startFrom = stringA.length();
        String finalPart = stringB.substring(startFrom+word);

        return finalPart;
    }


    public static void main(String[] args) {
        StringPart3 stringPart3 = new StringPart3();
        System.out.println(stringPart3.twoOccurrences("a", "banana"));
        System.out.println(stringPart3.lastPart("a","banana"));
    }
}
