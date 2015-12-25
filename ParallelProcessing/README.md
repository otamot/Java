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
今回の実装は次のとおりである。
taskの開始メッセージの出力、1秒スリープ、タスク終了メッセージである。
そして、taskNumを返すという単純なものとした。


このようにinterface Callable\<V\>をimplementsすることによって、taskを簡単に実装できる。
Callableではメソッドで処理をし、値を返し、例外をスローすることができる。

Runnableインターフェースをimplementsすることでも同じようなことができるが、処理の結果を返すことが出来なかったり(void)、例外をスローすることができない。

### Mainクラス
Mainクラスでは、スレッドの発行、taskの実行、スレッドの終了、結果の出力まで一連の動作を記述する。


#### ExecutorService
* newFixedThreadPool
* newSingleThreadExecutor
* newFixedScheduledExecutor
* newSingleScheduledExecutor










### 実行結果
* threadNum = 4のとき
```
task0 is start
task2 is start
task3 is start
task1 is start
task3 is end
task1 is end
task2 is end
task0 is end
task5 is start
task7 is start
task4 is start
task6 is start
task7 is end
task6 is end
task4 is end
task5 is end
task9 is start
task8 is start
task9 is end
task8 is end
[0]
[1]
[2]
[3]
[4]
[5]
[6]
[7]
[8]
[9]
```

* threadNum = 1のとき
```
task0 is start
task0 is end
task1 is start
task1 is end
task2 is start
task2 is end
task3 is start
task3 is end
task4 is start
task4 is end
task5 is start
task5 is end
task6 is start
task6 is end
task7 is start
task7 is end
task8 is start
task8 is end
task9 is start
task9 is end
[0]
[1]
[2]
[3]
[4]
[5]
[6]
[7]
[8]
[9]
```
