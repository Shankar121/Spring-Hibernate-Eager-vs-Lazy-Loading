package com.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="youtube_channel")
	private String youtubeChannnel;
	@Column(name="hobby")
	private String hobby;
	//@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)
	@OneToOne(mappedBy="instructorDetail",cascade= {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public InstructorDetail(String youtubeChannnel, String hobby) {
		super();
		this.youtubeChannnel = youtubeChannnel;
		this.hobby = hobby;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYoutubeChannnel() {
		return youtubeChannnel;
	}
	public void setYoutubeChannnel(String youtubeChannnel) {
		this.youtubeChannnel = youtubeChannnel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannnel=" + youtubeChannnel + ", hobby=" + hobby + "]";
	}

	public InstructorDetail() {
		
	}
}
