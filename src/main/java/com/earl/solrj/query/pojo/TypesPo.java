package com.earl.solrj.query.pojo;

/**
 * 类别表.
 * @author superGG
 *
 */
public class TypesPo {
	
	//类别id
	private Integer id;
	//类别名
	private String typeName;
	//父类别id
	private Integer parentTypeId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getParentTypeId() {
		return parentTypeId;
	}
	public void setParentTypeId(Integer parentTypeId) {
		this.parentTypeId = parentTypeId;
	}
	
	@Override
	public String toString() {
		return "TypesPo [typeId=" + id + ", typeName=" + typeName
				+ ", parentTypeId=" + parentTypeId + "]";
	}
	
	
}
