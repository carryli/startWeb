package org.carryli.work.service;

import java.util.List;

import org.carryli.work.dao.MemberDao;
import org.carryli.work.entity.Member;
import org.carryli.work.service.impl.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {

		this.memberDao = memberDao;
	}

	@Override
	public boolean addMember(Member member) {
		return memberDao.save(member);
		
	}

	@Override
	public boolean deleteMember(Member member) {

		return memberDao.delete(member.getMemberid());
		
	}

	@Override
	public boolean updateMember(Member member) {

		return memberDao.update(member);
		
	}

	@Override
	public List<Member> findAll() {

		return memberDao.getAll();
	}
	
	@Override
	public boolean deleteMemberById(Integer id) {

		return  memberDao.delete(id);
	}
	
	@Override
	public Member findMemberById(Integer id) {
		
		return memberDao.load(id);
	}

}
