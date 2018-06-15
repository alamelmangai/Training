package com.cg.project.collections;

public class MyGenericType<T extends Comparable<T>>{
	private T obj1,obj2;

	public MyGenericType(T obj1, T obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public T getObj1() {
		return obj1;
	}

	public void setObj1(T obj1) {
		this.obj1 = obj1;
	}

	public T getObj2() {
		return obj2;
	}

	public void setObj2(T obj2) {
		this.obj2 = obj2;
	}
	

}
