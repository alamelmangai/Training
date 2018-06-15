package com.cg.project.main;
import java.util.ArrayList;
import java.util.List;
public class Main {
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("ABC");
		strList.add("DEF");
		strList.add("GHI");
		iterateOnList(strList);
		
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		iterateOnList(intList);
	}
	//private static void iterateOnList(ArrayList<?> elements){
	//private static void iterateOnList(List<?> elements){	
	private static void iterateOnList(List<? extends Comparable<?>> elements){
		for (Comparable<?> comparable : elements) 
			System.out.println(elements);
	}
}
