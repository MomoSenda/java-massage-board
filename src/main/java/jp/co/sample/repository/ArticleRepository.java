package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Article;

/**
 * articleテーブルを操作するリポジトリ.
 * 
 * @author momo.senda
 *
 */
@Repository
public class ArticleRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Article> ARTICLEROWMAPPER=(rs,i)->{
		Article article= new Article();
		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));
		//article.setCommentList(rs.);
		return article;
		
	};
	
	public List<Article> findAll(){
		//初級：String sql="SELECT id,name,content FROM articles ORDER BY id";
		String sql="SELECT a.id,a.name,a.content,c.id,c.name,c.content,c.article_id From articles as a INNER JOIN comments as c ON a.id=c.article_id"; 
		
		List<Article> articleList=template.query(sql,ARTICLEROWMAPPER);
		return articleList;
	}
	
	public void insert(Article article) {
		SqlParameterSource param =new BeanPropertySqlParameterSource(article);
		String insertSql="INSERT INTO articles (name,content) VALUES (:name,:content)";
		template.update(insertSql, param);
	}
	
	public void deleteById(Integer id) {
		String deleteSql="DELETE FROM articles WHERE id=:id";
		SqlParameterSource param=new MapSqlParameterSource().addValue("id", id);
		
		template.update(deleteSql, param);
	}
}
