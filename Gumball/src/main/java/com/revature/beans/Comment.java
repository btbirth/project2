package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="COMMENTS")
public class Comment {
	@Id
	@Column(name="COMMENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="COMMENT_BODY", nullable=false)
	private String body;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="READER_ID")
	private Reader reader;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="ARTICLE_ID")
	private Article article;
	public Comment() {
		super();
	}
	public Comment(String body, Reader reader, Article article) {
		super();
	
		this.body = body;
		this.reader = reader;
		this.article = article;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@JsonIgnore
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	@JsonIgnore
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", body=" + body + "]";
	}
	
	
}
