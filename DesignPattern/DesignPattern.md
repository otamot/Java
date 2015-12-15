# Design Pattern 
* 2015/12/7 13:00-14:30
* OPP

## Iterator Pattern
* for文でのiを抽象化して一般化したもの
* iterator = 反復子
* for文ではダメ
* Iteratorはboolean hasNext()とObject next()をもつ。
* 教科書はジェネリクスを使っていない。
* public interface Iterator<E>{
* 	public abstract boolean hasNext();
* 	public abstract E next();
* }
* 
* public interface Aggregate<E>{
*	public abstract Iterator<E> iterator();
* }
*
* implements Agregate<Book>
* public interface<Book> iterator();
* implements Iterator<Book>
* public Book next()
* ×Book book = (Book) it.next();
* ○Book book = it.next();

## Factory Method Pattern
* インスタンスを生成する工場をTemplete Method PatternでつくったものをFactory Method Pattern
* productクラス：製品を表す。
* Factoryクラス：Templete Methodを使っている。
* ID Card クラス

# Singletone Pattern
* インスタンスが１個しか持たないことを保証する
* コンストラクタをprivateにしておく必要がある。

