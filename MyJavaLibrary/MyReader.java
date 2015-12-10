import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

//例外処理しなくても良い、Readerをまとめる。
public class MyReader{
	private static BufferedReader br;
	public MyReader(String filePath, String encode){
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),encode));
		}catch(UnsupportedEncodingException | FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String readLine(){
		try{
			return br.readLine();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	public void close(){
		try{
			br.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}


