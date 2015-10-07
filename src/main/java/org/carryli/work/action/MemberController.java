package org.carryli.work.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.carryli.work.entity.Member;
import org.carryli.work.service.impl.MemberService;;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST, headers="Accept=*/*")
	public String Register(@ModelAttribute("member")Member member, ModelMap model){
		model = new ModelMap();
		List<Member> members = memberService.findAll();
		if(members != null && members.size()!=0){
			model.put("members", members);
			return "success";
		}else{
			return "study";
		}
	}
}
