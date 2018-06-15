import java.io.File;
import java.io.IOException;

public class MainClass1 {

	public static void main(String[] args) {
try {
	File Fromfile=new File("d:\\ChinnuJavaCode.txt");
	File Tofile=new File("d:\\FLPDataFile.txt");
	ByteStreamDemo.byteReadWriteWork(Fromfile, Tofile);
} catch (IOException e) {
	e.printStackTrace();
}

	}

}