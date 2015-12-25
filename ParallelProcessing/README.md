# Javaで並列処理プログラミング
## Executorを使う

```Java
int threadNum = 4; //スレッド数。同時に処理するタスクの数。

ExecutorService executor = Executors.newFixedThreadPool(threadNum);//4スレッドでタスク消化。
```


