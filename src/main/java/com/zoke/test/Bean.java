package com.zoke.test;

public class Bean {

	private int a;
	private int b;
	private int c;
	private int d;

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Bean{" +
				"a=" + a +
				", b=" + b +
				", c=" + c +
				", d=" + d +
				'}';
	}
}
