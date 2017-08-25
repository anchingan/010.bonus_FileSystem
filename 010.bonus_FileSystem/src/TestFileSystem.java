/*
 * Practice 010.bonus_File system
 * 				Build an easy simulated file system.
 * Date 20170819
 */

import java.util.Scanner;

public class TestFileSystem {

	public static void main(String[] args) {
		Directory root = new Directory("root");
//		System.out.println(root);
		String a = root.getClass().toString();
//		System.out.println(a);
//		System.out.println(root.getClass().toString());
//		System.out.println(root.getClass().getName());
		Directory testa = new Directory("testa", root);
		root.addItem(testa);
		root.search("a");
		File rootFileA = new File("rootFileA");
		root.addItem(rootFileA);
		File rootFileB = new File("rootFileB");
		root.addItem(rootFileB);
		File testaFileB = new File("testaFileB");
		testa.addItem(testaFileB);
//		root.search("a");
//		root.search("B");
		System.out.println(root.search("A"));
		System.out.println(root.search("a"));
		System.out.println(root.search("B"));

	}

}
