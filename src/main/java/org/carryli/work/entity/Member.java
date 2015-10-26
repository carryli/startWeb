package org.carryli.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@XmlRootElement
@Table(name = "member")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="org.carryli.work.entity.Member")
public class Member {
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="memberid")
	private int memberid;
	@Column(name="name")
	private String name;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;

	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "memberid|"+memberid+" name|"+name+" phone|"+phone+" email|"+email;
	}
	
}
