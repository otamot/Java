import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
* 例外処理しなくて良い、Writerをまとめる。
* @author YutaTomomatsu
*/
public class MyWriter{
	private BufferedWriter bw;

	/**
	* コンストラクタ
	* @param filePath	書き込みファイルのパス
	* @param encode		文字コード
	*/
	public MyWriter(String filePath,String encode){
		try{
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),encode));
		}catch(UnsupportedEncodingException|FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	* 文字列をファイルに書き込む。
	* @param str		書き込む文字列
	*/
	public void print(String str){
		try{
			bw.write(str);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	/**
	* 文字列をファイルに書き込み、改行する。
	* @param str		書き込む文字列
	*/
	public void println(String str){
		print(str + "\n");
	}
	
	/**
	* 空行を書き込む。
	*/
	public void newLine(){
		println("");
	}

	/**
	* ファイルをクローズする。
	*/
	public void close(){
		try{
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
