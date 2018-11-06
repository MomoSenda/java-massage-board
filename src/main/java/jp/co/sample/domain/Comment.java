package jp.co.sample.domain;

/**
 * コメントの情報を表すドメイン
 * 
 * @author momo.senda
 *
 */
public class Comment {
	/**ID*/
	private Integer id;
	/**名前*/
	private String name;
	/**コンテント（投稿内容）*/
	private String content;
	/**記事のID*/
	private Integer articleId;
	
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", content=" + content + ", articleId=" + articleId
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getContent()=" + getContent()
				+ ", getArticleId()=" + getArticleId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	

}
