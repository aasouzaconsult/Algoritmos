/**
 * IO.java - versao 1.1
 * Contains support methods for vc0's data entry.
 *
 * This code is part of the Computador Visivel - vc0
 * Copyright (c) 2002, Jorge H. C. Fernandes (jorge@dimap.ufrn.br)
 * Todos os direitos reservados. All rights reserved.
 * Uso irrestrito para fins educacionais e não lucrativos.
 * Free use only for educational and nonprofit purposes
*/

class IO {
    private static final short MAX_INPUT_LEN = 256;
    private static byte[] bytes = new byte[MAX_INPUT_LEN];
    private static char[] caracts = new char[MAX_INPUT_LEN];
    public static String readStr () {
        for (int i = 0; i < MAX_INPUT_LEN; i++) {
            bytes[i] = '\n';
        }

        try {
            // os dados são capturados do teclado
            System.in.read(bytes, 0, MAX_INPUT_LEN);
        }
        catch (Exception e) {
            System.out.println(e);
            // um string null é retornado em caso de erro 
            return null;
        }
        int qtdBytesDigitados = MAX_INPUT_LEN;
        // cada um dos bytes é examinado
        for (int i = 0; i < MAX_INPUT_LEN; i++) {
            // copia os bytes ateh que um caractere de retorno <enter> seja encontrado
            if (bytes[i] == '\n') {
              qtdBytesDigitados = i;
              break;
            }
            caracts[i] = (char) bytes[i];
        }
        // um string é criado com os caracteres encontrados até o '\n'
        String str = (new String(caracts, 0, qtdBytesDigitados-1));
        return str;
    }
    // retorna um inteiro lido do teclado
    public static int readInt() {
        // usa a string retornada por readStr(), removendo os caracteres em branco
        String str = readStr().trim();
        // converte a string para inteiro
        return (Integer.parseInt(str));
    }
    public static short readShort() {
        // le um inteiro no teclado e o converte para um short
    	return (short) readInt();
    }    
    public static double readDouble(){
        // usa a string retornada por readStr(), removendo os caracteres em branco
        String str = readStr().trim();
        // converte a string para ponto flutuante de dupla precisão
        return (Double.parseDouble(str));
    }
    public static float readFloat(){
        // lê um double do teclado e o converte para float
        return (float)readDouble();
    }
    public static void readEnter () {
        // le um string qualquer até encontrar o enter
        readStr();
    }
    public static void println(String str) {
        // atalho para System.out.println
    	System.out.println(str);
    }
    public static void println(Object obj) {
        // atalho para System.out.println
    	System.out.println(obj);
    }
    public static void print(Object obj) {
    	System.out.print(obj);
    }
    public static void println(int numero) {
    	System.out.println(numero);
    }
    public static void print(int numero) {
    	System.out.print(numero);
    }
    public static void main(String[] args) {
        println("Testando IO");

        println("Digite um string e tecle <enter>");
        String s = IO.readStr();
        println("O string digitado foi["+s+"]");

        println("Digite um inteiro e tecle <enter>");
        int i = IO.readInt();
        println("O int digitado foi["+i+"]");

        println("Digite um short e tecle <enter>");
        short sh = IO.readShort();
        println("O short digitado foi["+sh+"]");

        println("Digite um float e tecle <enter>");
        float f = readFloat();
        println("O float digitado foi["+f+"]");

        println("Digite um double e tecle <enter>");
        double d = readDouble();
        println("O double digitado foi["+d+"]");

        println("Tecle <enter> para encerrar o programa");
        readEnter();
        println("Fim do teste");
    }
}


