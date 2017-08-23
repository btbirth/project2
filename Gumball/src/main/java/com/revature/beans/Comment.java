package com.revature.beans;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment {
	@Id
	@Column(name="COMMENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment")
	@SequenceGenerator(name="comment", sequenceName="COMMENT_SEQUENCE")
	private int id;
	@Column(name="COMMENT_BODY")
	private String body;
	@ManyToOne
	private Reader reader;
	@ManyToOne
	private Article article;
}
