import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TUTEDECC {

    public static void main(String [] args){
        try {
            detectaPadrao("in.txt",  "padron.txt", "out.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aplica linha a linha do ficheiro de texto fileIn a capitalização pretendida e escreve o resultado no
     * ficheiro com o nome fileOut.
     * @param fileIn O nome do ficheiro de input
     * @param tipo -1 aplica a capitalização tudo minúsculas
     *             0 aplica a capitalização à primeira letra da linha ou à primeira letra depois de um ponto final
     *             1 aplica a capitalização tudo maiúsculas
     * @param fileOut O nome do ficheiro de output
     * @throws IOException
     */
    public static void capitalizar ( String fileIn , int tipo , String fileOut ) throws IOException {

        //Read the input file
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        //Read the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        //Get all the shit together
        StringBuilder sb = new StringBuilder();

        //Ler cada linha do ficheiro e colocar em memória
        String line = "";
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        //O texto todo do ficheiro
        String allTheText = sb.toString();

        //De acordo com o tipo de operação fornecida
        String processedText;
        StringBuilder output = new StringBuilder();
        switch(tipo){
            case -1:
                //Efectuar a operação requerida
                output.append(allTheText.toLowerCase());
                break;

            case 0:
                boolean dotFound = false;
                for (int i = 0; i < allTheText.length(); i++){

                    //Primeira letra uppercase
                    if(i == 0){
                        output.append(Character.toUpperCase(allTheText.charAt(i)));

                    //Ponto achado
                    }else if(allTheText.charAt(i) == '.'){
                        dotFound = true;
                        output.append(allTheText.charAt(i));

                    //Não e a primeira letra nem ponto
                    }else {
                        //Se for letra, uppercase e gastar o ponto achado
                        if(Character.isLetter(allTheText.charAt(i)) && dotFound){
                            output.append(Character.toUpperCase(allTheText.charAt(i)));
                            dotFound = false;

                        //Não é letra
                        }else{
                            output.append(allTheText.charAt(i));
                        }
                    }
                }
                break;

            case 1:
                //Efectuar a operação requerida
                output.append(allTheText.toUpperCase());
                break;
        }

        bw.write(output.toString());
        bw.close();
        br.close();
    }

    /**
     * Retira os caracteres ( case sensitive ) escritos na primeira linha do ficheiro de texto de nome fileLetras do
     * ficheiro de texto com o nome fileIn, linha a linha.
     * @param fileIn O nome do ficheiro de input
     * @param fileLetras Os caracteres a serem retiradas do texto
     * @param fileOut O nome do ficheiro de output
     * @throws IOException
     */
    public static void retiraCaracteres (String fileIn , String fileLetras , String fileOut ) throws IOException {

        //Read the input file
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        //Read the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        //Get all the shit together
        StringBuilder sb = new StringBuilder();

        //Ler cada linha do ficheiro e colocar em memória
        String line = "";
        String firstLine;
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        //O texto todo do ficheiro
        String allTheText = sb.toString();

        //De acordo com o tipo de operação fornecida
        String processedText = allTheText.replaceAll("[" + fileLetras +"]", "");

        //Escrita do output
        bw.write(processedText);
        bw.close();
        br.close();
    }

    /**
     * A cada linha do ficheiro de texto com o nome fileIn retira os pontos finais e os espaços e troca todos
     * os algarismos por a sua escrita em extensão
     * @param fileIn O nome do ficheiro de input
     * @param fileOut O nome do ficheiro de output
     * @throws IOException
     */
    public static void numerosPorLetras (String fileIn , String fileOut ) throws IOException {

        //Lista dos numeros por extenso
        String [] numeros = new String[]{"zero", "um", "dois", "tres", "quatro", "cinco", "seis", "sete", "oito", "nove"};

        //Read the input file
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        //Read the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        //Get all the shit together
        StringBuilder sb = new StringBuilder();

        //Ler cada linha do ficheiro e colocar em memória
        String line = "";
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }

        //O texto todo do ficheiro
        String allTheText = sb.toString();

        //Retirar todos os pontos e espaços
        String processedText = allTheText.replaceAll("[ .]", "");

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < processedText.length(); i++) {

            char currentChar = processedText.charAt(i);

            if(Character.isDigit(currentChar)) {
                int pos = Integer.parseInt(Character.toString(currentChar));
                temp.append(numeros[pos]);
            } else {
                temp.append(currentChar);
            }
        }

        //Escrita do output
        bw.write(temp.toString());
        bw.close();
        br.close();

    }

    /**
     * Aplica linha a linha a remoção da pontuação e dos espaços e uma rotação de quanto a cada uma das letras.
     * @param fileIn O nome do ficheiro de input
     * @param fileOut O nome do ficheiro de output
     * @param quanto O numero de incrementos na posicao dos caracteres
     * @throws IOException
     */
    public static void rotacao ( String fileIn , String fileOut , int quanto ) throws IOException {

        //ASCII
        String [] asciiLOWER = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String [] asciiUPPER = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String [] asciiNUMERIC = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        //Read the input file
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        //Read the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        //Get all the shit together
        StringBuilder sb = new StringBuilder();

        //Ler cada linha do ficheiro e colocar em memória
        String line = "";
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }

        //O texto todo do ficheiro
        String allTheText = sb.toString();

        //Retirar todos os pontos e espaços
        String processedText = allTheText.replaceAll("[ .]", "");

        StringBuilder temp = new StringBuilder();
        int charValue = 0;
        //Iteracoes feitas atraves do calculo do valor (ascii + quanto) % numChars de cada tipo (lower, UPPER, numeric)
        for (int i = 0; i < processedText.length(); i++) {

            char currrentChar = processedText.charAt(i);
            charValue = (int) currrentChar;

            //É digito?
            if(Character.isDigit(currrentChar)){
                temp.append(asciiNUMERIC[(((charValue - 48) + quanto) % asciiNUMERIC.length)]);

            //É lowercase
            }else if (Character.isLowerCase(currrentChar)){
                temp.append(asciiLOWER[(((charValue - 97) + quanto) % asciiLOWER.length)]);
            //É UPPER?
            }else if (Character.isUpperCase(currrentChar)){
                temp.append(asciiUPPER[(((charValue - 65) + quanto) % asciiUPPER.length)]);
            //É outro char qualquer, não interessa
            }else{
                temp.append(currrentChar);
            }

        }

        //Escrita do output
        bw.write(temp.toString());
        bw.close();
        br.close();
    }

    /**
     *
     * @param fileIn O nome do ficheiro de input
     * @param fileOut O nome do ficheiro de output
     * @param tipo Define o tipo da analise a fazer
     * @throws IOException
     */
    public static void fequenciasLetras ( String fileIn , String fileOut , int tipo ) throws IOException {

        String [] asciiLOWER = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        //A LinkedHashMap mantém a ordem de inserção
        Map<String, Float> charCounter = new LinkedHashMap();


        //Read the input file
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        //Read the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        //Get all the shit together
        StringBuilder sb = new StringBuilder();

        //Ler cada linha do ficheiro e colocar em memória
        String line = "";
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }

        //O texto todo do ficheiro (em lowercase pra contar a e A como o mesmo)
        String allTheText = sb.toString().toLowerCase();

        //Retirar todos os caracteres que nao sao a-z
        String processedText = allTheText.replaceAll("[^a-z]", "");
        //Quantidade inicial de caracteres do texto processado
        int counter = processedText.length();
        //Backup do texto processado para se tranformar
        String temp = processedText;

        switch(tipo){
            //Ordem Alfabética
            case 0:

                for (int j = 0; j < asciiLOWER.length; j++) {
                    //Retirar todos os asciiLOWER[i] (a -> z)
                    temp = temp.replaceAll(asciiLOWER[j], "");
                    //Calcular a diferenca de caracteres entre a iteracao anterior e a seguinte e por no map
                    charCounter.put(asciiLOWER[j], (float) (counter - temp.length()) / processedText.length());
                    //Actualizar o numero de caracteres para calcular o seguinte
                    counter = temp.length();
                }

                break;
            //Ordem encontrada
            case 1:

                while(counter > 0){
                    //Obter o primeiro caracter
                    Character c = temp.charAt(0);
                    //Retirar todas as ocorrencias de caracter
                    temp = temp.replaceAll(c.toString(), "");
                    //Calcular a diferenca de caracteres entre a iteracao anterior e a seguinte e por no map
                    charCounter.put(c.toString(), (float) (counter - temp.length()) / processedText.length());
                    //Actualizar o numero de caracteres para calcular o seguinte
                    counter = temp.length();
                }

                break;
        }

        //Map para a formatacao certa e escrita em ficheiro
        StringBuilder out = new StringBuilder();
        for (String key : charCounter.keySet()) {

            out.append(key + " : " + charCounter.get(key).toString() + "\n");
        }

        bw.write(out.toString());
        bw.close();
        br.close();
    }

    /**
     * Lê do ficheiro de texto com o nome filePadroes os padrões que estão separados por espaço e procura linha a linha
     * no ficheiro de texto com o nome fileIn cada um dos padrões, indicando (se aparecerem!) quantas vezes aparecem e
     * no final a contagem total de cada um dos padrões
     *
     * @param fileIn O nome do ficheiro de input
     * @param filePadroes O nome do ficheiro de padroes
     * @param fileOut O nome do ficheiro de output
     * @throws IOException
     */
    public static void detectaPadrao (String fileIn , String filePadroes, String fileOut ) throws IOException {

        Map <String, Integer> counter = new LinkedHashMap<>();

        //Read the input file
        BufferedReader br = new BufferedReader(new FileReader(fileIn));
        //Read the input file
        BufferedReader pd = new BufferedReader(new FileReader(filePadroes));
        //Read the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));

        //Povoar a lista dos totais de cada padrao
        String [] pattern = pd.readLine().split(" ");
        for (String s: pattern) {
            counter.put(s, 0);
        }

        //Ler cada linha do ficheiro e colocar em memória
        String line = "";
        int lineNumber = 1;
        while((line = br.readLine()) != null){

            //Depois da leitura da linha
            for (String s : pattern) {
                //Contar o tamanho da linha original
                int lngt = s.length();
                //Retirar o padrao actual
                String tmp = line.replaceAll(s, "");
                //Calcular a diferenca e dividir plo num chars do padrao
                int cnt = (line.length() - tmp.length()) / s.length();

                //Atualizar a contgem dos totais
                counter.put(s, counter.get(s) + cnt);
                System.out.println(s + " ocorre na linha " + lineNumber + ", " + cnt + " vez(es).");


            }
            lineNumber++;
            System.out.println();
        }

        //Apresentacao dos totais
        System.out.println("Numero de ocorrencias dos padroes:");
        for (String key : counter.keySet()) {
            System.out.println(key + " : " + counter.get(key));
        }


    }
}
