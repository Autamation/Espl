package com.prakat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AChecker_ResultSetObj_Accesibility")
public class AcheckerResultsetVo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "achecker_Id")
	private int achecker_Id;

	@Column(name = "columnNum")
	private String columnNum;

	@Column(name = "errorMsg")
	private String errorMsg;

	@Column(name = "errorSourceCode")
	private String errorSourceCode;

	@Column(name = "lineNum")
	private String lineNum;

	@Column(name = "resultType")
	private String resultType;

	public String getColumnNum() {
		return columnNum;
	}

	public void setColumnNum(String columnNum) {
		this.columnNum = columnNum;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorSourceCode() {
		return errorSourceCode;
	}

	public void setErrorSourceCode(String errorSourceCode) {
		this.errorSourceCode = errorSourceCode;
	}

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

}
