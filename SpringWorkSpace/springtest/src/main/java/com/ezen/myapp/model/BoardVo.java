package com.ezen.myapp.model;

public class BoardVo {
	
	private int    bidx;    //번호
	private String subject; //내용
	
	/* setter */
	public void setBidx(int bidx)          { this.bidx = bidx;       }
	public void setSubject(String subject) { this.subject = subject; }
	
	/* getter */
	public int getBidx()       { return bidx;    }
	public String getSubject() { return subject; }
	
}
