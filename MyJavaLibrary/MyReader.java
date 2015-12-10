import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/**
* 例外処理しなくても良い、Readerをまとめたクラス。
* @author YutaTomomatsu
*/
public class MyReader{
	private static BufferedReader br;

	/**
	* コンストラクタ
	* @param filePath	読み込みファイルのパス
	* @param encode		読み込みファイルの文字コード
	*/
	public MyReader(String filePath, String encode){
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),encode));
		}catch(UnsupportedEncodingException | FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	* 1行読み込み。
	* 例外処理は不要
	*/
	public String readLine(){
		try{
			return br.readLine();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	/**
	* Readerをクローズする。
	*/
	public void close(){
		try{
			br.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}


