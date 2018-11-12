package classesBasicas;

public class unikeId {
	private static int id=1000000;
	
	public static int getIdKey(){
		unikeId.id+=1;
		return unikeId.id;
	}
}
