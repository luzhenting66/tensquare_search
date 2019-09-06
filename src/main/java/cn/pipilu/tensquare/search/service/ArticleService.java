package cn.pipilu.tensquare.search.service;

import cn.pipilu.tensquare.search.request.AddArticleReq;
import cn.pipilu.tensquare.search.request.QueryArticleReq;
import cn.pipilu.tensquare.search.response.QueryArticleResp;

public interface ArticleService {

    void save(AddArticleReq reqData);

    QueryArticleResp findByKeyword(QueryArticleReq reqData);
}
