# java.util.Function
* 関数型インターフェースを提供するパッケージ。
* ラムダ式やメソッド参照のターゲットとなる型を提供。

## Function<T,R>
* TからRへの単一引数関数
* R apply(T t)メソッドを持つ。

### Consumer<T>
* Tからvoidへの単一引数関数
* void accept(T t)メソッドを持つ。

### Predicate<T>
* Tからbooleanへの単一引数関数
* boolean test<T t>メソッドを持つ。

### Supplier<R>
* Rへの引数なし関数。
* R get()メソッドを持つ。

## BiFunction<T,U,R>
* 2つの引数T,UからRを返す関数。
* Functionの引数２個Ver.
