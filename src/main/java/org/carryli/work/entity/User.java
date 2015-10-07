package org.carryli.work.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1981841332793662600L;
	private int id;
	private String username;
	private String password;
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
    
}
