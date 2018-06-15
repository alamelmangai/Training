import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class ByteStreamDemo {
	public static void byteReadWriteWork(File fromFile,File toFile) throws IOException{
		try(BufferedInputStream src = new BufferedInputStream(new FileInputStream(fromFile))){
			try(BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(toFile))){
				//1st
				int a=0;
				while((a=src.read())!=-1)
						System.out.print((char)a);
				dest.write(a);
				//2nd
				byte[] dataBuffer = new byte[(int)fromFile.length()];
				src.read(dataBuffer);
				System.out.print(new String(dataBuffer));
				dest.write(dataBuffer);
				}
		}
	}
}
		/*FileInputStream src=new FileInputStream(fromFile);
		FileOutputStream dest=new FileOutputStream(toFile);
		//1st
		int a=0;
		while((a=src.read())!=-1)
				System.out.print((char)a);
		dest.write(a);
		//2nd
		byte[] dataBuffer = new byte[(int)fromFile.length()];
		src.read(dataBuffer);
		System.out.print(new String(dataBuffer));
		dest.write(dataBuffer);
	}*/
	
