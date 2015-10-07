package org.carryli.work.service.impl;

import java.util.List;

import org.carryli.work.entity.Member;

public interface MemberService {
	public void addMember(Member member);
	public void deleteMember(Member member);
	public void updateMember(Member member);
	public List<Member> findAll();
}
