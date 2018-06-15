package com.cg.iowork;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void doSerialization(File file) throws FileNotFoundException,IOException{
		Associate associate = new Associate(100,15000,"alamel","mangai");
		try(ObjectOutputStream dest = new ObjectOutputStream(new FileOutputStream(file))){
			dest.writeObject(associate);
		}
		System.out.println("Associate Details has transaferred to "+file.getAbsolutePath());
		}
	public static void doDeSerialization(File file) throws FileNotFoundException,IOException, ClassNotFoundException{
		try(ObjectInputStream src = new ObjectInputStream(new FileInputStream(file))){
			Associate associate = (Associate)src.readObject();
		}
	}

}
