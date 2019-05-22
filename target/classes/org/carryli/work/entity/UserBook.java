package org.carryli.work.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "userbook")
public class UserBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1981841332793662600L;
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="recordId")
	private Integer recordId;
	@Column(name="userId")
	private Integer userId;
	@Column(name="bookId")
	private Integer bookId;
	@Column(name = "borrowDate")
	private Date borrowDate;
	public UserBook(){
		
	}
	public UserBook(String userId, String bookId, String recordId, String borrowDate){
		this.userId = Integer.parseInt(userId);
		this.recordId = Integer.parseInt(recordId);
		this.bookId = Integer.parseInt(bookId);
		 StringTokenizer st = new StringTokenizer(borrowDate, "-");   
		 this.borrowDate = new java.sql.Date(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                 Integer.parseInt(st.nextToken()));
	}
	
	
	
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		 StringTokenizer st = new StringTokenizer(borrowDate, "-");  
		this.borrowDate = new java.sql.Date(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                 Integer.parseInt(st.nextToken()));
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
