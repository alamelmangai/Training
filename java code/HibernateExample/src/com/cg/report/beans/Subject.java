package com.cg.report.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectId;
	private float mark;
	private String subjectName;
	public Subject(){}
	
	public Subject(float mark, String subjectName) {
		super();
		this.mark = mark;
		this.subjectName = subjectName;
	}

	public Subject(int subjectId, float mark, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.mark = mark;
		this.subjectName = subjectName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(mark);
		result = prime * result + subjectId;
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (Float.floatToIntBits(mark) != Float.floatToIntBits(other.mark))
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", mark=" + mark + ", subjectName=" + subjectName + "]";
	}
	
	
}