package classesBasicas;

public class UnikeId {
	private static int id=1000000;
	
	public static int getIdKey(){
		UnikeId.id+=1;
		return UnikeId.id;
	}
}
