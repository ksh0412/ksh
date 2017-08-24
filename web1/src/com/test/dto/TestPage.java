package com.test.dto;

public class TestPage {
	private int tnum;
	private String tname;
	private String tinfo;
	private String thome;
	private String tph;
	private String command;
	private int nowPageCnt=1;
	private int totalCnt=0;
	private int totalPageCnt=0;
	private int blockCnt=10;
	private int totalBlockCnt=0;
	private int startRow = 0;
	private int startBlock = 0;
	public int endBlock = 0;

	
	public void cal(){
		if(totalCnt%blockCnt==0){
			totalPageCnt = totalCnt/blockCnt;
		}else if(totalCnt%blockCnt!=0){
			totalPageCnt = totalCnt/blockCnt + 1;
		}
		if(totalPageCnt%blockCnt==0){
			totalBlockCnt = totalPageCnt/blockCnt;
		}else if(totalPageCnt%blockCnt!=0){
			totalBlockCnt = totalPageCnt/blockCnt +1;
		}
		startRow = (nowPageCnt-1)*10;
		startBlock = (nowPageCnt-1)/10+1;
		endBlock = getStartBlock() + blockCnt -1;
		System.out.println("startBlock"+startBlock);
	} 
	
	public int getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}
	
	public int getNowPageCnt() {
		return nowPageCnt;
	}
	public void setNowPageCnt(int nowPageCnt) {
		this.nowPageCnt = nowPageCnt;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		cal();
	}
	public int getTotalPageCnt() {
		return totalPageCnt;
	}
	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}
	public int getBlockCnt() {
		return blockCnt;
	}
	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}
	public int getTotalBlockCnt() {
		return totalBlockCnt;
	}
	public void setTotalBlockCnt(int totalBlockCnt) {
		this.totalBlockCnt = totalBlockCnt;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTinfo() {
		return tinfo;
	}
	public void setTinfo(String tinfo) {
		this.tinfo = tinfo;
	}
	public String getThome() {
		return thome;
	}
	public void setThome(String thome) {
		this.thome = thome;
	}
	public String getTph() {
		return tph;
	}
	public void setTph(String tph) {
		this.tph = tph;
	}
	
}
