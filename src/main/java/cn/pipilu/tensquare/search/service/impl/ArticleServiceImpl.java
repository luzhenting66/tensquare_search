package cn.pipilu.tensquare.search.service.impl;

import cn.pipilu.plus.common.util.IdUtils;
import cn.pipilu.tensquare.search.dao.ArticleDao;
import cn.pipilu.tensquare.search.pojo.ArticleEntity;
import cn.pipilu.tensquare.search.request.AddArticleReq;
import cn.pipilu.tensquare.search.request.QueryArticleReq;
import cn.pipilu.tensquare.search.response.QueryArticleResp;
import cn.pipilu.tensquare.search.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IdUtils idUtils;

    private void save(ArticleEntity article) {
        article.setId(idUtils.getIdStr());
        articleDao.save(article);
        logger.info("=========== 索引保存成功 ===============");
    }

    @Override
    public void save(AddArticleReq reqData) {
        ArticleEntity article = new ArticleEntity();
        article.setState("0");
        article.setContent(reqData.getContent());
        article.setTitle(reqData.getTitle());
        save(article);
    }

    @Override
    public QueryArticleResp findByKeyword(QueryArticleReq reqData) {
        QueryArticleResp resp = new QueryArticleResp();
        String keyword = reqData.getKeyword();

        Pageable pageable = PageRequest.of(reqData.getPageNo()- 1,reqData.getPageSize());
        Page<ArticleEntity> page = articleDao.findByTitleOrContentLike(keyword, keyword,pageable);
        resp.setData(page.getContent());
        resp.setTotal(page.getTotalElements());
        resp.setSize(page.getSize());
        resp.setTotalPage(page.getTotalPages());
        return resp;
    }
}
