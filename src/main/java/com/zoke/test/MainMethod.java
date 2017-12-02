package com.zoke.test;

public class MainMethod {

	public static void main(String[] args) {
		Bean b = new Bean();

		b.setA(3453);
		b.setB(48357);
		b.setC(348);
		b.setD(458);

		System.out.println(b);
		System.out.println("我是新增加的内容");
	}

	public void run1(){
		System.out.println("增加了一个方法");
	}

}
