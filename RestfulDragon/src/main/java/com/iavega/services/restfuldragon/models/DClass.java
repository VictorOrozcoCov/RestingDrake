package com.iavega.services.restfuldragon.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_classes", schema = "dungeon_schema")
public class DClass implements Serializable {
	private static final long serialVersionUID = -5697950250572602535L;

	//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Id
	@Column(name = "class_id")
	private Integer classId;

	@Column(name = "class_name")
	private String className;

	public DClass() {
	}

	public DClass(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "DClass [classId=" + classId + ", className=" + className + "]";
	}

}
