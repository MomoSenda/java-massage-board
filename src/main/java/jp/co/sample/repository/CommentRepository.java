package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Comment;

@Repository
public class CommentRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Comment> COMMENTROWMAPPER=(rs,i)->{
		Comment comment=new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));
		
		return comment;
		
	};
	
	public List<Comment> findByArticleId(int articleId){
		String sql="SELECT id,name,content,article_id FROM comments WHERE article_id=:articleId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		List<Comment> commentList = template.query(sql, param, COMMENTROWMAPPER);
		
		return commentList;
		
	}
	
	public void insert(Comment comment) {
		SqlParameterSource param =new BeanPropertySqlParameterSource(comment);
		String insertSql="INSERT INTO comments (article_id,name,content) VALUES (:articleId,:name,:content)";
		template.update(insertSql, param);
	}
	
	public void deleteByArticleId(int articleId) {
		String deleteSql="DELETE FROM comments WHERE article_id=:articleId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId",articleId);
		
		template.update(deleteSql,param);
	}
	
	
}
