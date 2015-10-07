package org.carryli.work.service;

import java.util.List;

import org.carryli.work.dao.MemberDao;
import org.carryli.work.entity.Member;
import org.carryli.work.service.impl.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void addMember(Member member) {
		memberDao.save(member);
		
	}

	@Override
	public void deleteMember(Member member) {
		memberDao.delete(member);
		
	}

	@Override
	public void updateMember(Member member) {
		memberDao.update(member);
		
	}

	@Override
	public List<Member> findAll() {
		return memberDao.getAll();
	}

}
