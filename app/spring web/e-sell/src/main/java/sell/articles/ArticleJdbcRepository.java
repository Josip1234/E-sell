package sell.articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import sell.sellers.Sellers;
/***
 * 
 * @author Josip Bošnjak
 * This class is implementation of interface of article table.
 * 
 *
 */
@Slf4j
@Repository
public class ArticleJdbcRepository implements ArticleRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public ArticleJdbcRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	@Override
	public Iterable<Articles> findAll() {
		return jdbc.query("select article_number,article_name,seller from Articles", this::mapRowToArticles);

	}

	@Override
	public Articles findOne(String value) {
		
		return (Articles) jdbc.query("select article_number,article_name,seller from Articles where article_number="+value, this::mapRowToArticles);
	}

	@Override
	public Articles save(Articles articles) {
		log.info("Values:"+articles);
		System.out.println(articles.getSeller());
		jdbc.update(
				"insert into Articles (article_number, article_name,seller) values(?,?,?)",
				articles.getArticle_number(),
				articles.getArticle_name(),
				articles.getSeller()
				);
		return articles;
	}
	private Articles mapRowToArticles(ResultSet rs, int rowNum) throws SQLException {
		return new Articles(
				rs.getString("article_number"),
				rs.getString("article_name"),
				rs.getString("seller"));
	
	}
    
	/***
	 * This function founds all articles from current user.
	 * First query for selection of all data is done. Conversion from iterable is done.
	 * Then new array list is created.
	 * There is a string of seller username which will be used to compare velus.
	 * Lambda expression is used to compare string with article seller in return article 
	 * list. If they are the same, object will be added to empty list. That list will be returned.
	 */
	@Override
	public List<Articles> findAllByUsername(Sellers seller) {
		List<Articles> listFromDatabase=(List<Articles>) findAll();
		List<Articles> returnArticles= new ArrayList<Articles>();
	   String compare=seller.getNickname();
	
	    returnArticles = listFromDatabase.stream()
	      .filter(article -> compare.contains(article.getSeller()))
	      .collect(Collectors.toList());
		return returnArticles;
	}

	@Override
	public Articles findByArticleNumber(String article_number) {
		
		return jdbc.queryForObject("select article_number, article_name,seller from Articles WHERE article_number = ? ", this::mapRowToArticles, article_number);
	}








}
