import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

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
            	 
                 texto += (char) content;
                 
             }
             
             String[] linhas = texto.split("\n");
             Token token = new Token();
             
             for(int i=0; i<linhas.length; i++){
            	 
        		 String caracter = linhas[i];
        		 
        		   if(caracter.startsWith("//"))
        		   {
        			   
        			   break;
        			   
        		   }else{
            	 
            	 for(int j = 0; j < linhas[i].length(); j++){

            	
          	       switch (caracter.charAt(j)) {
     	            case 'p':
                           if(caracter.startsWith("program")){
                        	   //é aceito, separar em ID E HELLOWORD ATÉ O PONTO E VÍRGULA

                               System.out.println("program HelloWord;");
                           }
                        	  //pega do caracter j até o ;
     	                break;
     	            case 'v':
     	            	if(caracter.substring(j, j + 2) == "var"){
                      	  System.out.println("Token aceito: var");
                        }
     	                break;
     	            case 'b':
     	            	if(caracter.substring(j, j + 4) == "begin"){
                      	  System.out.println("Token aceito: begin");
                        } 
     	                break;
     	            case 'e':
     	            	if(caracter.substring(j, j + 3) == "end."){
                        	  System.out.println("Token aceito: end.");
                          }
     	                break;
     	            case 'w':
     	            	if(caracter.substring(j, j + 6) == "writeln"){
                      	  System.out.println("Token aceito: writeln");
                        }
     	                break;
     	            default:
     	                 System.out.println();
     	         }
          	  
            		
            		 
            		
            		 
            	 } //for j

        		   }//else
          	   
             }//for i
             
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
     
     

}
