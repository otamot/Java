public class Rambda1{
	public static void main(String[] args){
		Ramda1Interface ramda = (String name)->{
			System.out.println("Hello,"+name);
		};
		ramda.sayHello("James");
	}
}

@FunctionalInterface
interface Ramda1Interface{
	public void sayHello(String name);
}
