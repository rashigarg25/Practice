package com.practice.spring.beans;

import java.util.Iterator;
import java.util.List;

public class PrintListAndConstructorInitialize {

	private List<String> stringList;

	public PrintListAndConstructorInitialize(List<String> stringList) {
		this.stringList = stringList;
	}

	public void printList() {
		Iterator<String> itr = stringList.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
