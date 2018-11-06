package jp.co.sample.form;

public class CommentForm {
	/**記事ID*/
	private String articleId;
	/**コメント投稿者の名前*/
	private String name;
	/**コメント内容*/
	public String content;
	
	
	
	@Override
	public String toString() {
		return "CommentForm [articleId=" + articleId + ", name=" + name + ", content=" + content + ", getArticleId()="
				+ getArticleId() + ", getName()=" + getName() + ", getContent()=" + getContent() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public int getIntArticleId() {
		return Integer.parseInt(articleId);
	}
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
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
