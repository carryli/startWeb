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
@Table(name = "book")
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1981841332793662600L;
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="bookId")
	private Integer bookId;
	@Column(name = "bookName")
	private String bookName;
	@Column(name="author")
	private String author;
	@Column(name="address")
	private String location;
	@Column(name="status")
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
