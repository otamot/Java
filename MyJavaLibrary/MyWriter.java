import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

//例外処理しなくて良い、Writerをまとめる。
public class MyWriter{
	private BufferedWriter bw;
	public MyWriter(String filePath,String encode){
		try{
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),encode));
		}catch(UnsupportedEncodingException|FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void print(String str){
		try{
			bw.write(str);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void println(String str){
		print(str + "\n");
	}

	public void newLine(){
		println("");
	}

	public void close(){
		try{
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
