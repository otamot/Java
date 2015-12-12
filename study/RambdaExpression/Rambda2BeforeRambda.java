import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

//List内の要素を全件表示。
//ラムダ式を使う前。
class Rambda2BeforeRambda{
	public static void main(String[] args){
		List<String> cities = new ArrayList<String>();
		cities.add("京都");
		cities.add("大阪");
		cities.add("神戸");
		cities.forEach(new Consumer<String>() {
			public void accept(final String city) {
				System.out.println(city);
			}
		});
	}
}
