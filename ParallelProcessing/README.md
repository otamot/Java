# Javaで並列処理プログラミング
## Executorを使う
Executorを用いて並列化プログラミングを行う。

* Mainクラス
```Java
package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		//task数の指定
		int taskNum = 10;
		//同時に処理するスレッドの数。
		int threadNum = 4;
											
		//スレッド数を指定してスレッドプールを作成する。
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		//taskを入れるList
		List<Callable<String>> tasks = new ArrayList<>();
		for(int i = 0; i < taskNum; i++){
			tasks.add(new Task(i));
		}
																												
		try{
			//tasksを並列実行。結果をFutureのListに入れる。
			List<Future<String>> futures = executor.invokeAll(tasks);
		
			//ExecutorServiceの終了
			if(executor != null){
				executor.shutdown();
			}

			//結果の出力
			for(Future<String> future: futures){
				System.out.println(future.get());
			}
		}catch(Exception e){
			e.printStackTrace(System.err);
		}	
	}
}


```

* Taskクラス
```java

package Thread;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	int taskNum;
	
	@constructor
	Task(int taskNum){
		this.taskNum = taskNum;
	}

	@Override
	public String call() throws Exception {
		System.out.println("task" + taskNum + " is start");
		Thread.sleep(1000);
		System.out.println("task" + taskNum + " is end");	
		return "[" + taskNum + "]";
	}
}
```

### Taskクラス
まず、Taskクラス。
ここには並列化したい処理を書いていく。
その際に、Callable\<V\>を実装する必要がある。
\<V\>はジェネリクスで、並列化した処理の結果を返す時の型を指定できる。

``` java
class Task implements Callable<Void>{} //結果を返さない処理を並列化するとき
class Task implements Callable<Double>{} //Double型の結果を返したい時
```

Callableインターフェースは以下のメソッドを実装する必要がある。

``` java
V call() throws Exception
```

このcallメソッドは実際に並列化したい処理を記す。
taskの開始時と終了時にメッセージを出力する。
今回は1秒sleepしてtaskNumを返すという単純なものとした。




### Mainクラス
Mainクラスでは、スレッドの発行、taskの実行、スレッドの終了、結果の出力まで一連の動作を記述する。


#### Executors
* newFixedThreadPool
* newSingleThreadExecutor
* newFixedScheduledExecutor
* newSingleScheduledExecutor


