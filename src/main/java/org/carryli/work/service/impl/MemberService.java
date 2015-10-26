package org.carryli.work.service.impl;

import java.util.List;

import org.carryli.work.entity.Member;

public interface MemberService {
	public boolean addMember(Member member);
	public boolean deleteMember(Member member);
	public boolean deleteMemberById(Integer id);
	public boolean updateMember(Member member);
	public Member findMemberById(Integer id);
	public List<Member> findAll();
}
