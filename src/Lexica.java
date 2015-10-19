import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * DATA: 12/10/2015
 * Análise léxica é o processo de analisar a entrada de linhas de caracteres (tal como o código-fonte de um 
 * programa de computador) e produzir uma seqüência de símbolos chamado "símbolos léxicos" (lexical tokens), 
 * ou somente "símbolos" (tokens), que podem ser manipulados mais facilmente por um parser (leitor de saída).
 * 
 * A Análise Léxica é a forma de verificar determinado alfabeto. Quando analisamos uma palavra, podemos definir 
 * através da análise léxica se existe ou não algum caractere que não faz parte do nosso alfabeto, ou um alfabeto 
 * inventado por nós. O analisador léxico é a primeira etapa de um compilador, logo após virá a análise sintática.
 * */
public class Lexica {
	
	public String textFile = "";
	
     Lexica(String path){
    	 
    	 scanToken(path);
    	 
     }
     
     
     private byte scanToken(String path){
    	 
    	 
    	 /* MANIPULAÇÃO DE ARQUIVO */
    	 File file = new File(path); 
    	 
    	 FileInputStream fis = null;
         String texto = "";
         
         try {
             fis = new FileInputStream(file);
             int content;
             while ((content = fis.read()) != -1) {
            	 
            	 Token token = new Token();
            	 
                 texto += (char) content;
                 
                 // 
                	        switch (content) {
                	            case 1:
                	            	System.out.println();
                	                break;
                	            case 2:
                	                System.out.println();
                	                break;
                	            case 3:
                	                System.out.println();
                	                break;
                	            case 4:
                	                System.out.println();
                	                break;
                	            case 5:
                	                System.out.println();
                	                break;
                	            case 6:
                	                System.out.println();
                	                break; 
                	             case 7:
                	                System.out.println();
                	                break;
                	            default:
                	                 System.out.println();
                	         }
               
//
                 
             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (fis != null) {
                     fis.close();
                 }
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
         }
    	 /* FIM MANIPULAÇÃO DE ARQUIVO */
        
    	 
    	 
		return 0;
    	 
     }
     
     
     public String takeIt(char caracter){
    	 
    	 return this.textFile += caracter;
    	 
     }
     
     

}
