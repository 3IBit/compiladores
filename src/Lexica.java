import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


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
	
	private String keyword[] = { "var", "identificador", "begin", "end", ";", "(", ")", "end.", "program" };
	
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
            	 String searchWord = "";
            	 String[] wordSplit = null;
        		 String caracter = linhas[i];
        		 
        		   if(caracter.startsWith("//"))
        		   {
        			   System.out.println("Passou aqui");
        			   break;
        			   
        		   }else{

        			   System.out.println("Passou aqui2");
            	 for(int j = 0; j < linhas[i].length(); j++){
            	
          	       switch (caracter.charAt(j)) {
     	            case 'p':
  	            	       searchWord = "program";
                           wordSplit = caracter.split(" ");
                           for(String string : wordSplit){
                        	   if(string.trim().equals("program")){
                        	     token.addID(string);
                        	     System.out.printf("Adicionado com sucesso. ID = %s", string);
                        	   }
                        	   else
                        		   //quando não for program for outra palavra fazer alguns métodos para verificação
                        		   System.out.println("Não é");
                        	   
                           }
                        	  //pega do caracter j até o ;
     	                break;
     	            case 'v':
     	            	System.out.println("To aqui");
     	            	if(caracter.substring(j, j + 2) == "var"){
     	            		String ch = caracter.replace("var", "");
     	            		System.out.println(ch);
     	            		String[] car = ch.split(",");
     	            		
     	            		for(String string : car){
         	            		token.addVariable(string);	
     	            		}
     	            		token.showVariable();
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
     
     
     
     public boolean searchToken(String caracter){
    	
 		
 		boolean status = false;
 		
 		for(String string : keyword){
 			if(string.trim().toUpperCase() == caracter.trim().toUpperCase())
 			{
 				status = true;
 				System.out.println(status);
 			} 

        }
 		
 		return status;
 		
 	}
     
     

}
