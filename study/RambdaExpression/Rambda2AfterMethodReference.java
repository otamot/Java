import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

//List内の要素を全件表示。
//メソッド参照使用。
class Rambda2AfterMethodReference{
	public static void main(String[] args){
		List<String> cities = new ArrayList<String>();
		cities.add("京都");
		cities.add("大阪");
		cities.add("神戸");
		cities.forEach(System.out::println);
	}
}
