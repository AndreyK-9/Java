import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        String txt = "ПримерМоегоЗашифрованногоТекста";
        String txt2 = "иоаоок-мешвгс-рМЗрне-ПрофнТаегиаот-";
        int[] keyIn = {3, 4, 2, 1, 5};
//        int[] keyGen = setKeyGen(txt);
//        System.out.println(Arrays.toString(keyIn));
//        System.out.println(txt.length());
//        char[][] crypt = coding(txt,keyIn);
//        printCodingText(crypt, keyIn);
        char[][] decrypt = decoding(txt2, keyIn);
        printDecodingText(decrypt, keyIn);


    }

    public static int[] setKeyGen (String txt){
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

        double txtLength = txt.length();
        double keyLength = key.length;
        double rowDouble = Math.ceil((txtLength / keyLength));

        int columns = key.length;
        int row = (int) rowDouble;
        char c = '-';
        int d = row * columns - txt.length();

               for (int i = 0; i < d; i++) {
                   txt += c;
               }

        char[] ch = txt.toCharArray();
        char[][] crypt = new char[row][columns];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                crypt[i][j] = ch[index];
                index += 1;

            }
        }
        return crypt;
    }

    public static void printCodingText(char[][] crypt, int[] key){


            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < crypt.length; j++) {
                    System.out.print(crypt[j][key[i]-1]);
                }
            }


    }

    public static char[][] decoding(String txt, int[] key){

        double txtLength = txt.length();
        double keyLength = key.length;
        double rowDouble = Math.ceil((txtLength / keyLength));

        int columns = key.length;
        int row = (int) rowDouble;

        char[] ch = txt.toCharArray();
        char[][] decrypt = new char[row][columns];
        int index = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < row; j++) {
                decrypt[j][key[i]-1] = ch[index];
                index += 1;

            }
        }
        return decrypt;
    }

    public static void printDecodingText(char[][] decrypt, int[] key){


        for (int i = 0; i < decrypt.length; i++) {   //строки
            for (int j = 0; j < key.length; j++) {   //столбцы
                System.out.print(decrypt[i][j]);
            }
        }


    }

}
