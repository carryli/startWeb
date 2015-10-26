package org.carryli.work.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="org.carryli.work.entity.User")
public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1981841332793662600L;
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	private Integer id;
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	private String lastName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Role> authorities = new ArrayList<Role>();
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	
	@Column(name="username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "daycost")
	private String daycost;
	
	@Column(name = "maxday")
	private String maxday;
	
	public String getDaycost() {
		return daycost;
	}
	public void setDaycost(String daycost) {
		this.daycost = daycost;
	}
	public String getMaxday() {
		return maxday;
	}
	public void setMaxday(String maxday) {
		this.maxday = maxday;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return true;
	}
	
	public String toString(){
		return "username|"+username+" password|"+password;
		
	}
	/**
	 * 多对多双向关联:一个事件多个参与人 由于在主动方Person中定义了多对多的关系。 此处如果没有业务上的需求，可以省略该属性。不是必须定义的。 主动方采用连接表，被动方采用mappedBy属性
	 *private Set<Person> participants = new HashSet<Person>();
			@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
    		mappedBy = "events", 
    		fetch = FetchType.LAZY)
	 * @uml.property  name="participants"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="events:com.xuyuan.hibernate3.tutorial.domain.Person"
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) authorities;
	}
    
}