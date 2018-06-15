import java.io.File;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
try {
	File file = new File("d:\\ChinnuJavaCode.txt");
	if(!file.exists())
		file.createNewFile();
	System.out.println(file.length());
	System.out.println(file.canRead());
	System.out.println(file.canWrite());
} catch (IOException e) {
	e.printStackTrace();
}

	}

}
