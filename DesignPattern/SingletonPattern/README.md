# Singleton Pattern
* そのクラスのインスタンスをたった1つしか持たないことを保証したクラス
* ロケールやLook&Feelなど、絶対にアプリケーション全体で統一しなければならない仕組みの実装に使用される。

## 注意すべき点
* 同じ型のインスタンスが private なクラス変数として定義されている。
* コンストラクタの可視性が private である。
* 同じ型のインスタンスを返す getInstance() がクラス関数として定義されている。