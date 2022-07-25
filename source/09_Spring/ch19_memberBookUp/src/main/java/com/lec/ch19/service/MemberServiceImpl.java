package com.lec.ch19.service;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		// member.getMname()에게 메일보내기, member insert, session에 mid attribute 추가하기
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width:500px; margin: 0 auto; text-align: center\">\n" + 
					"	<h1 style=\"color:blue;\">"+ member.getMname() +"님 회원가입 감사합니다</h1>\n" + 
					"	<div>\n" + 
					"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
					"		<p>\n" + 
					"			<img src=\"http://localhost:8090/ch19/img/coupon.jpg\">\n" + 
					"		</p>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"		<img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\">\n" + 
					"	</div>\n" + 
					"	<p>서울시 어떤구 XX로 00 **빌딩 402</p>\n" + 
					"</div>"; 
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, 
											new InternetAddress(member.getMmail())); // 받는 메일
				mimeMessage.setFrom(new InternetAddress("spacenyi0@gmail.com")); // 보내는 메일
				mimeMessage.setSubject(member.getMname()+"님 회원가입 감사합니다(쿠폰 동봉)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message); // 메일 발송
		httpSession.setAttribute("mid", member.getMid()); // 세션에 mid 속성 추가
		return memberDao.joinMember(member); // member insert
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memb
		return result;
	}

	@Override
	public Member getDetailMember(String mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
