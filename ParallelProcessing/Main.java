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
		int threadNum = 1;
		
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
