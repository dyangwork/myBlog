package com.blog.myblog.vo;

/**
 * @author dongyang
 * @description TODO
 * @className BlogMetaVO
 * @date 2019/5/15
 **/
public class BlogMetaVO{
	
	/**
	 * 分类标签id
	 */
	private String cid;
	
	/**
	 * 分类/标签 名称
	 */
	private String name;
	
	/**
	 * tags/category 类型
	 */
	private String type;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 排序
	 */
	private int sort;
	
	/**
	 * 分类涉及文章数
	 */
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	

}
