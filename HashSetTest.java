package com.practice.Collections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Objects;

public class HashSetTest  {

	public static void main(String[] args) {
		
		HashSet<Book> hs=new HashSet<Book>();
		Book b1 = new Book(23313, "Java8", "Vishhal", "2ndEdition", 125, 345);
		Book b2 = new Book(23314, "Java9", "Balu", "3rdEdition", 130, 34.5f);
		Book b3 = new Book(23311, "Java11", "Sneha", "1stEdition", 50, 450);
		
		hs.add(b1);
		hs.add(b2);
		hs.add(b3);
		
		for (Book book : hs) {
			System.out.println(book);
		}
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("D://temp//HashSet.txt");
			System.out.println("File is ready");
			ObjectOutputStream oos=new ObjectOutputStream(fout);
			System.out.println("Object is ready");
			System.out.println(hs);
			oos.writeObject(hs);
			System.out.println("Process completed");
			oos.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * static void doExposeDetails(HashSet<Book> x) { try { FileOutputStream
	 * fout=new FileOutputStream("D://temp//HashSet.txt");
	 * System.out.println("File is ready"); ObjectOutputStream oos=new
	 * ObjectOutputStream(fout); System.out.println("Object is ready");
	 * System.out.println(x); oos.writeObject(x);
	 * System.out.println("Process completed"); oos.close(); fout.close(); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 */
}
//innovate comparator interface with your uniquely designed object
//innovate treemap example
//serialize the book using hashset and deserialize 

class Book{
	long booknum;
	String booktitle;
	String bookAuthor;
	String addition;
	int numOfPages;
	float bookPrice;
	public Book(long booknum, String booktitle, String bookAuthor, String addition, int numOfPages, float bookPrice) {
		super();
		this.booknum = booknum;
		this.booktitle = booktitle;
		this.bookAuthor = bookAuthor;
		this.addition = addition;
		this.numOfPages = numOfPages;
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Book [booknum=" + booknum + ", booktitle=" + booktitle + ", bookAuthor=" + bookAuthor + ", addition="
				+ addition + ", numOfPages=" + numOfPages + ", bookPrice=" + bookPrice + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(addition, bookAuthor, bookPrice, booknum, booktitle, numOfPages);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(addition, other.addition) && Objects.equals(bookAuthor, other.bookAuthor)
				&& Float.floatToIntBits(bookPrice) == Float.floatToIntBits(other.bookPrice) && booknum == other.booknum
				&& Objects.equals(booktitle, other.booktitle) && numOfPages == other.numOfPages;
	}
	
	
}
