package org.carryli.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.carryli.work.entity.Member;
import org.carryli.work.service.impl.MemberService;;

@Controller
@RequestMapping("/comments")
public class MemberController {

	@Autowired
	private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list( ModelMap map)
	{
		List<Member> members = memberService.findAll();
		map.put("member",members);
		map.put("msg","fetch "+members.size()+" members");
	    return "success";
	}

	@RequestMapping(value = "/getMember", method = RequestMethod.GET)
	public String getMember(@RequestParam("id")Integer id, ModelMap map)
	{
		Member member = memberService.findMemberById(id);
		map.put("member",member);
	    return "success";
	}

	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id")Integer id, ModelMap map, HttpSession session)
	{
		String msg = "delete finish";
		if(memberService.deleteMemberById(id)){
			session.setAttribute("msg",msg);
		}else{
			msg = "delete failed";
			session.setAttribute("msg",msg);
		}
		map.put("msg",msg);
	    return "success";
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("member") Member member, ModelMap map, HttpSession session)
	{
		if(memberService.addMember(member)){
			map.put("msg","save finish");
			session.setAttribute("msg","save finish");
		}else{
			map.put("msg","save failed");
			session.setAttribute("msg","save failed");
		}
	    return "success";
	}
	
}
