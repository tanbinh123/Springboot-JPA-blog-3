package kr.nexparan.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder //빌드 패턴
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity //Reply클래스가 Mariadb에 테이블이 생성된다.
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length=200)
	private String content;
	
	@ManyToOne //Many = Reply, One = Board 여러개의 댓글은 하나의 게시글에만 존재한다.
	@JoinColumn(name = "boardId")
	private Board board;
	
	@ManyToOne //Many = Reply, One = User 한 유저는 여러개의 댓글을 달 수 있다. 
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
