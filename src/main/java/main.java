import java.util.*;

public class main {
    String sonnet = "Two households, both alike in dignity, " +
            "In fair Verona, where we lay our scene, " +
            "From ancient grudge break to new mutiny, " +
            "Where civil blood makes civil hands unclean. " +
            "From forth the fatal loins of these two foes " +
            "A pair of star-cross’d lovers take their life; " +
            "Whose misadventured piteous overthrows " +
            "Do with their death bury their parents’ strife. " +
            "The fearful passage of their death-mark’d love, " +
            "And the continuance of their parents’ rage, " +
            "Which, but their children’s end, nought could remove, " +
            "Is now the two hours’ traffic of our stage; " +
            "The which if you with patient ears attend, " +
            "What here shall miss, our toil shall strive to mend.";

    public String replaceChar(String str, String ch, int index) {
        return str.substring(0, index) + ch + str.substring(index+1);
    }

    public String spaces (int len){
        String f = "";
        for (int i = 0; i < len; i++) {
            f += "-";
        }
        return f;
    }

    public String input (){
        Scanner inp = new Scanner(System.in);

        String respose = inp.nextLine();

        inp.close();
        return respose;
    }

    public void main(String[] args){
        //cleaning
        sonnet = sonnet.toLowerCase();
        List<Character> unwanted = Arrays.asList(',', ';', '.');
        for (int i = 0; i < sonnet.length() - 1; i++) {
            if (unwanted.contains(sonnet.charAt(i))){
                sonnet = replaceChar(sonnet, "", i);
            }
//            System.out.print(sonnet.charAt(i));
        }

        List<String> sWords = Arrays.asList(sonnet.split(" "));

        Random rand = new Random();
        int r = rand.nextInt(sWords.size());

        int tries = 0;
        int start = 0;
        while ((tries < 3) && (r < sWords.size()-1)){
            System.out.println(String.join(" ", sWords.subList(start,r)));
            System.out.println(spaces(sWords.get(r).length()));

            String response = input();
            System.out.println(response);

            if (Objects.equals(response, sWords.get(r))){
                System.out.println("true");
                start = r;
                r = rand.nextInt(r+1, sWords.size());
            } else {
                tries += 1;
                System.out.println("false");
                r = 1000;
            }
        }
        System.out.println(sWords.subList(r, sWords.size()));

    }
}