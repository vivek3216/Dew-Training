package com.dew.training.dto;

public class Schooling {
	private String name;     //board name-cbse, ib
	private String marks;
	private int yearOfPassing;
	private String board;   // medium- english, hindi
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	
}
