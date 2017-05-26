package com.edu.chapter4.products;

public class Shop {
	private Note noteObj;
	private Pencil pencilObj;
	private Slipper sliperObj;
	
	public Shop(){}
	public Shop(Note noteObj, Pencil pencilObj, Slipper sliperObj){
		this.noteObj = noteObj;
		this.pencilObj = pencilObj;
		this.sliperObj = sliperObj;
	}
	
	public Note getNoteObj() {
		return noteObj;
	}
	public void setNoteObj(Note noteObj) {
		this.noteObj = noteObj;
	}
	public Pencil getPencilObj() {
		return pencilObj;
	}
	public void setPencilObj(Pencil pencilObj) {
		this.pencilObj = pencilObj;
	}
	public Slipper getSliperObj() {
		return sliperObj;
	}
	public void setSliperObj(Slipper sliperObj) {
		this.sliperObj = sliperObj;
	}

}
