package com.example.codestates.Daily_Coding;

public class DecryptCaesarCipher {
    public static void main(String[] args) {
        String output = decryptCaesarCipher("khoor", 3);
        System.out.println(output); // --> hello

        output = decryptCaesarCipher("zruog", 3);
        System.out.println(output); // --> world
    }

    public static String decryptCaesarCipher(String str, int secret) {
        // TODO:
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int index = (str.charAt(i) - secret);
            if (index < 97) {
                index += 26;
            }
            if (str.charAt(i) != ' ') {
                char c = (char)index;
                sb.append(c);
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
