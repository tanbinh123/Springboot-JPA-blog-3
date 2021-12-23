package kr.nexparan.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder //빌드 패턴
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity //Board클래스가 Mariadb에 테이블이 생성된다.
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	//private int userId;
	@ManyToOne(fetch = FetchType.EAGER)//Many = Board, One = User 유저는 보드를 여러개 가질 수 있지만 보드는 유저를 하나밖에 갖지 못한다.
	@JoinColumn(name="userId")
	private User user;//DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)//mappedBy 연관관계의 주인이 아니다(난 FK에요
	//JoinColumn이 필요없다. 데이터만 가져다 쓸 예정임
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
