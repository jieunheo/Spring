package com.ezen.myapp.model;

public class MemberVo {
	
	private int    midx;       //번호
	private String memberId;   //아이디
	private String memberPw;   //비밀번호
	private String memberName; //이름
	private String writeday;   //가입일
	private String delYN;      //탈퇴여부
	
	/* setter */
	public void setMidx(int midx)                { this.midx = midx;             }
	public void setMemberId(String memberId)     { this.memberId = memberId;     }
	public void setMemberPw(String memberPw)     { this.memberPw = memberPw;     }
	public void setMemberName(String memberName) { this.memberName = memberName; }
	public void setWriteday(String writeday)     { this.writeday = writeday;     }
	public void setDelYN(String delYN)           { this.delYN = delYN;           }

	/* getter */
	public int    getMidx()       { return midx;       }
	public String getMemberId()   { return memberId;   }
	public String getMemberPw()   { return memberPw;   }
	public String getMemberName() { return memberName; }
	public String getWriteday()   { return writeday;   }
	public String getDelYN()      { return delYN;      }
	
}
