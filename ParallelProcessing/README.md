# Javaで並列処理プログラミング
## Executorを使う

Mainクラス
```Java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		int threadNum = 10;//thread数の指定
		ExecutorService executor = Executors.newFixedThreadPool(2);//同時に処理する数を指定。				
		String[] results = new String[threadNum];//threadの処理の結果を格納する配列。
											
		List<Callable<String>> tasks = new ArrayList<>();//taskを入れるList
		for(int i = 0; i < threadNum; i++){
			tasks.add(new Task(i));
		}
																						
		try{
			List<Future<String>> futures;
			futures = executor.invokeAll(tasks);
			for(int i = 0; i < threadNum; i++){
				results[i] = futures.get(i).get();
			}
			if(executor != null){
				executor.shutdown();
				for(String s: results){
					System.out.println(s);
				}
			}
		}catch(Exception e){
			e.printStackTrace(System.err);
		}
	}
}
```

Taskクラス
```java
package Thread;
import java.util.concurrent.Callable;
public class Task implements Callable<String> {
	int taskNum;

	Task(int taskNum){
		this.taskNum = taskNum;
	}

	@Override
	public String call() throws Exception {
		//	System.out.println("task" + taskNum + " is start");
		//	System.out.println("task" + taskNum + " is end");
		for(int i = 0; i < 20; i++){
			System.out.println(taskNum);
			Thread.sleep(10);
		}
		return "task" + taskNum + " is end";
	}	
}
```


### Taskクラス
まず、Taskクラス。
ここには並列化したい処理を書いていく。
その際に、Callable<V>を実装する必要がある。
<V>はジェネリクスで、並列化した処理の結果を返す時の型を指定できる。

``` java
class Task implements Callable<Void>{} //結果を返さない処理を並列化するとき
class Task implements Callable<Double>{} //Double型の結果を返したい時
```

Callableインターフェースは以下のメソッドを実装する必要がある。

``` java
V call() throws Exception
```

このcallメソッドは実際に並列化したい処理を記す。
今回は1秒sleepしてtaskNumを返すという単純なものとした。




### Mainクラス
