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
//	private Integer parentTypeId;
	
	private TypesPo parentType;
	
	public TypesPo getParentType() {
		return parentType;
	}
	public void setParentType(TypesPo parentType) {
		this.parentType = parentType;
	}
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
	@Override
	public String toString() {
		return "TypesPo [id=" + id + ", typeName=" + typeName + ", parentType="
				+ parentType + "]";
	}
}
