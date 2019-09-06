package cn.pipilu.tensquare.search.dao;

import cn.pipilu.tensquare.search.pojo.ArticleEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ArticleDao extends ElasticsearchCrudRepository<ArticleEntity,String> {
}
