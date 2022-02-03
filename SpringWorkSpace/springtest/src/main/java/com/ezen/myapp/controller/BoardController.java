package com.ezen.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {

	@RequestMapping(value="/board/boardWrite.do")
	public String boardWrite() {
		
		/* boardWrite.jsp �������� �̵� */
		return "boardWrite";
		
	}
	
	@RequestMapping(value="/board/boardWriteAction.do")
	public String boardWriteAction(@RequestParam("subject") String subject) {
		
		/* boardWriteAction ó�� �� boardList �������� �̵� */
		
		//1. boardWriteAction ó��
		//	1-1. �Ķ����(�Ű�����) �ޱ� -> @RequestParam("subject") String subject
		
		//	1-2. ���� DB�� �Է�(ó��)
		BoardDao db   = new BoardDao(); //��ü ����
		int      exec = db.insertBoard(subject); //�� �߰�
		
		//	1-3. ������ �̵� (sendRedirect)
		if(exec != 0) { response.sendRedirect(pj+"/board/boardList.do"); } //url �ܺ��̵�
		else { response.sendRedirect(pj+"/board/boardWrite.do"); } //url �����̵�
		
		//2. redirect: �� �̿��Ͽ� sendRedirect ����
		return "redirect:/board/boardList.do";
		
	}
	
}