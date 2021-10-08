import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String txt = "ПримерТекста";
        int[] key = setKey(txt);
        System.out.println(Arrays.toString(key));
        System.out.println(txt.length());
        char[][] crypt = coding(txt,key);
        printCodingText(crypt,key);


    }

    public static int[] setKey(String txt){
        int keyLength = 0;
        for (int i = 0; i < txt.length(); i++) {
            if (i*i >= txt.length()){
                keyLength = i;
                break;
            }

        }
        int key[] = new int[keyLength];

        for (int i = 0; i < keyLength; i++) {
            key[i] = i + 1;
        }
        for (int i = 0; i < keyLength; i++) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            int temp = key[j];
            key[j] = key[i];
            key[i] = temp;
        }
        return key;

    }

    public static char[][] coding(String txt, int[] key){
        int a = key.length;
        int b = txt.length();
        char c = '-';
        int d = a*a - b;

               for (int i = 0; i < d; i++) {
                   txt += c;
               }

        char[] ch = txt.toCharArray();
        char[][] crypt = new char[a][a];
        int index = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                crypt[i][j] = ch[index];
                index += 1;

            }

        }

        return crypt;


    }

    public static void printCodingText(char[][] crypt, int[] key){


            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    System.out.print(crypt[j][key[i]-1]);
                }
            }


    }

}
