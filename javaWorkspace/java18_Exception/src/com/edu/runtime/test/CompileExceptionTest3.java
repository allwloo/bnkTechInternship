package com.edu.runtime.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * 예외를 즉각적이게 처리하는 방법 try - catch
 * 
 * throws ----> 호출한 곳으로 예외를 던짐
 */
/*
 * fianlly 블락은 무조건 수행
 * 예외가 발생하건 안하건.....
 * 
 * finally 블락이 수행되지 않는 유일한 경우가 있음
 * --> 안에서 또다른 예외가 발생하면 안돌아감.
 */

// 기능만 구현하는 클래스에서는 throws만 써야함
// try catch문 구현은 호출된 클래스에서 (was)
class FileReading3{
	public void readFile(String fileName) throws IOException { 
		//파일 안의 내용을 읽어들이는 로직을 작성 .. .. ..]
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			System.out.println("FileReader Creating....");//complie에서 잡아서 출력이 됌
		}finally {
			fr.close();
		}
			System.out.println("fie.....end....;");
	}
}


// 메인에서 throws하면 jvm으로 간다
public class CompileExceptionTest3 {

	public static void main(String[] args) {
		FileReading3 fr = new FileReading3();
		
		try {
			fr.readFile("C:\\bnk_kgy\\eclipse\\javaWorkspace\\java01_OOP\\src\\test\\greetingTest.java");
		} catch (IOException e) {
		}
		System.out.println("파일을 잘 읽어들였습니다.");
	}

}
