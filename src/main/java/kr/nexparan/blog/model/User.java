package kr.nexparan.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder //빌드 패턴
@NoArgsConstructor
@AllArgsConstructor
@Entity //User클래스가 Mariadb에 테이블이 생성된다.
public class User {
	
	@Id //Primary Key가 된다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;//시쿼스, auto_increment
	
	@Column(nullable = false, length=30)
	private String username;
	@Column(nullable = false, length=100)
	private String password;
	@Column(nullable = false, length=50)
	private String email;
	
	//@ColumnDefault("user");
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. //admin, user, manager
	
	@CreationTimestamp //시간을 자동 입력
	private Timestamp createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	
	
}
