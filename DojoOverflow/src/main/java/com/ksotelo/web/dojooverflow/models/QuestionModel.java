package com.ksotelo.web.dojooverflow.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class QuestionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "debe ingresar una pregunta")
	@Size(min = 3, message = "la pregunta no debe ser más baja de 3 carácteres")
	private String question;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tags_question", 
	joinColumns = @JoinColumn(name = "question_id"), 
	inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<TagsModel> tags;
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	private List<AnswerModel> answers;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<TagsModel> getTags() {
		return tags;
	}

	public void setTags(List<TagsModel> tags) {
		this.tags = tags;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<AnswerModel> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerModel> answers) {
		this.answers = answers;
	}

	public QuestionModel() {
	}

	public QuestionModel(String question, List<TagsModel> tags) {
		this.question = question;
		this.tags = tags;
	}
}