import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

class Rambda2AfterRambda{
	public static void main(String[] args){
		List<String> cities = new ArrayList<String>();
		cities.add("京都");
		cities.add("大阪");
		cities.add("神戸");
		cities.forEach(city->System.out.println(city));
	}
}
