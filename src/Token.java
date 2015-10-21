import java.util.ArrayList;
import java.util.List;

public class Token {
	
	List<String> id  = new ArrayList<String>();
	List<String> var = new ArrayList<String>();
	
	public void addVariable(String var){
	    this.var.add(var);
				
	}
	
	public void addID(String id){
	    this.id.add(id);
				
	}
	
	public void showVariable(){
		for(int i = 0; i < var.size(); i++){
			System.out.printf("%s ", this.var.get(i));
		}
	}
	

	
	
	



}
