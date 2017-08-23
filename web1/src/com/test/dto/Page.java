package com.test.dto;

public class Page {

	private int nowPage = 1;
	private int startRow = 0;
	private int rowCnt = 10;
	private int blockCnt = 10;
	private int totalCnt = 0;
	private int totalPageCnt = 0;
	private int totalBlockCnt = 0;
	private int startBlock = 0;
	private int endBlock = 0;

	private void calPage(){
		totalPageCnt = (totalCnt/rowCnt)+1;
		startRow = (nowPage-1)*rowCnt;
		startBlock = ((nowPage-1)/blockCnt)*blockCnt+1;
		endBlock = getStartBlock()+blockCnt-1;
		if(endBlock>totalPageCnt){
			endBlock = totalPageCnt;
		}
	}
	public int getStartBlock() {
		return this.startBlock;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	public int getTotalPageCnt() {
		return totalPageCnt;
	}

	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public int getTotalBlockCnt() {
		return totalBlockCnt;
	}

	public void setTotalBlockCnt(int totalBlockCnt) {
		this.totalBlockCnt = totalBlockCnt;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		calPage();
	}

	public int getBlockCnt() {
		return blockCnt;
	}

	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}

	public int getStartRow() {
		return this.startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	@Override
	public String toString() {
		return "Page [nowPage=" + nowPage + ", startRow=" + startRow + ", rowCnt=" + rowCnt + ", blockCnt=" + blockCnt
				+ ", totalCnt=" + totalCnt + ", totalPageCnt=" + totalPageCnt + ", totalBlockCnt=" + totalBlockCnt
				+ ", startBlock=" + startBlock + ", endBlock=" + endBlock + "]";
	}
}
