import java.util.Map;
import java.util.HashMap;

public class Rambda3{
	public static void main(String[] args){
		Map<String,String> marchMap = new HashMap<String,String>();
		marchMap.put("M","Meiji Univ.");
		marchMap.put("A","Aoyama Gakuin Univ.");
		marchMap.put("R","Rikkyo Univ.");
		marchMap.put("C","Chuo Univ.");
		marchMap.put("H","Hosei Univ.");

		marchMap.forEach((key,value)->System.out.println(key + ":" + value));
	}
}
