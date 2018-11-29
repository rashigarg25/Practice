package com.practice.spring.beans;

public class FileLogger implements Logger {

	private String fileName;

	public FileLogger() {
	}

	public FileLogger(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void log(String message) {
		System.out.println("Printing log in filename : '" + fileName + "',  Message : '" + message + "'");
	}

}
