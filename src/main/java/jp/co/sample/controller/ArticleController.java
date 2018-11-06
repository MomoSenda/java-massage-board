package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Article;
import jp.co.sample.domain.Comment;
import jp.co.sample.form.ArticleForm;
import jp.co.sample.form.CommentForm;
import jp.co.sample.repository.ArticleRepository;
import jp.co.sample.repository.CommentRepository;

/**
 * 掲示板を表示するコントローラ.
 * 
 * @author momo.senda
 *
 */
@Controller
@Transactional
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleRepository articlerepository;

	@Autowired
	private CommentRepository commentRepository;

	@ModelAttribute
	public ArticleForm setUpForm() {
		return new ArticleForm();
	}

	@ModelAttribute
	public CommentForm setUpForm1() {
		return new CommentForm();
	}

	/**
	 * 記事の全件を表示する
	 * 
	 * @param model
	 *            モデル
	 * @return 表示画面
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		List<Article> articleList = articlerepository.findAll();
		for (Article article : articleList) {
			List<Comment> commentList = commentRepository.findByArticleId(article.getId());
			article.setCommentList(commentList);

		}
		model.addAttribute("articleList", articleList);

		return "articleinput";
	}

	/**
	 * 記事を追加する.
	 * 
	 * @param form
	 * @param model
	 * @return 表示画面
	 */
	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleForm form, Model model) {
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		articlerepository.insert(article);

		return "redirect:/article/list";
	}

	/**
	 * コメントを追加する.
	 * 
	 * @param form　コメントフォーム
	 * @param model モデル
	 * @return　初期画面
	 */
	@RequestMapping("/insertComment")
	public String insertComment(CommentForm form, Model model) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(form, comment);
		comment.setArticleId(form.getIntArticleId());
		
		commentRepository.insert(comment);
		return "redirect:/article/list";

	}
	
	
	/**
	 * 記事・コメントの削除.
	 * 
	 * @param id 記事id
	 * @return　初期画面
	 */
	@RequestMapping("/deleteArticle")
		public String deleteAticle(int id) {
		commentRepository.deleteByArticleId(id);
		articlerepository.deleteById(id);
		return "redirect:/article/list";
	}
	
	
	/**
	 * コメントの削除.
	 * @param articleId 記事のID
	 * @return
	 */
	@RequestMapping("/deleteComment")
		public String deleteComment (int articleId) {
		commentRepository.deleteByArticleId(articleId);
		
		return "redirect:/article/list";
	}
	


}
