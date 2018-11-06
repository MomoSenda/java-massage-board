package jp.co.sample.form;

/**
 * 投稿内容を受け取るフォーム.
 * 
 * @author momo.senda
 *
 */
public class ArticleForm {
	/**記事ID*/
	private String id;
	/**名前*/
	private String name;
	/**投稿内容*/
	private String content;
	
	@Override
	public String toString() {
		return "ArticleForm [id=" + id + ", name=" + name + ", content=" + content + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getContent()=" + getContent() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getIntId() {
		return Integer.parseInt(id);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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

	
	
}