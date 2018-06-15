package com.cg.iowork;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class MainClass {

	public static void main(String[] args) {
		try {
			File associateDataFile = new File("d:\\AssociateDataFile.txt");
			SerializationDemo.doSerialization(associateDataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}