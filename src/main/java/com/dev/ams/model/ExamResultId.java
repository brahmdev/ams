package com.dev.ams.model;
// Generated Mar 15, 2019, 9:06:04 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ExamResultId generated by hbm2java
 */
@Embeddable
public class ExamResultId  implements java.io.Serializable {


	 private Integer id;
	 private Integer studentDetailsId;

	public ExamResultId() {
	}

	public ExamResultId(Integer id, Integer studentDetailsId) {
	   this.id = id;
	   this.studentDetailsId = studentDetailsId;
	}
   

	@Column(name="id", nullable=false)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="student_details_id", nullable=false)
	public Integer getStudentDetailsId() {
		return this.studentDetailsId;
	}
	
	public void setStudentDetailsId(Integer studentDetailsId) {
		this.studentDetailsId = studentDetailsId;
	}


   public boolean equals(Object other) {
		 if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExamResultId) ) return false;
		 ExamResultId castOther = ( ExamResultId ) other; 
		 
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getStudentDetailsId()==castOther.getStudentDetailsId()) || ( this.getStudentDetailsId()!=null && castOther.getStudentDetailsId()!=null && this.getStudentDetailsId().equals(castOther.getStudentDetailsId()) ) );
   }
   
   public int hashCode() {
		 int result = 17;
		 
		 result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
		 result = 37 * result + ( getStudentDetailsId() == null ? 0 : this.getStudentDetailsId().hashCode() );
		 return result;
   }   


}


