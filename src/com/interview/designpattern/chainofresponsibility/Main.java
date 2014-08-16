package com.interview.designpattern.chainofresponsibility;

public class Main {
	private static Chain createChain() {
		// Build the chain of responsibility

		Chain chain1 = new A(Chain.Three);

		Chain chain2 = new B(Chain.Two);
		chain1.setNext(chain2);

		Chain chain3 = new C(Chain.One);
		chain2.setNext(chain3);

		return chain1;
	}

	public static void main(String[] args) {

		Chain chain = createChain();

		chain.message("level 3", Chain.Three);

		chain.message("level 2", Chain.Two);

		chain.message("level 1", Chain.One);
	}
}
