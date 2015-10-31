package com.cmli.correctivesystem.domain;

public class Customer {
	private int  id; 
	private String hanwen;
	private String shuxone;
	private String shuxtwo;
	private String minwen;
	private int file_id;
	private int sentence_no;
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getSentence_no() {
		return sentence_no;
	}
	public void setSentence_no(int sentence_no) {
		this.sentence_no = sentence_no;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHanwen() {
		return hanwen;
	}
	public void setHanwen(String hanwen) {
		this.hanwen = hanwen;
	}
	public String getShuxone() {
		return shuxone;
	}
	public void setShuxone(String shuxone) {
		this.shuxone = shuxone;
	}
	public String getShuxtwo() {
		return shuxtwo;
	}
	public void setShuxtwo(String shuxtwo) {
		this.shuxtwo = shuxtwo;
	}
	public String getMinwen() {
		return minwen;
	}
	public void setMinwen(String minwen) {
		this.minwen = minwen;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", hanwen=" + hanwen + ", shuxone="
				+ shuxone + ", shuxtwo=" + shuxtwo + ", minwen=" + minwen + "]";
	}
	public Customer(String minwen, String shuxone, String shuxtwo,
			String hanwen,int file_id,int sentence_no) {
		super();
		this.hanwen = hanwen;
		this.shuxone = shuxone;
		this.shuxtwo = shuxtwo;
		this.minwen = minwen;
		this.file_id=file_id;
		this.sentence_no=sentence_no;
	}
	public Customer() {
		super();
	}
	
}