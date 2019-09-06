package cn.pipilu.tensquare.search.controller;

import cn.pipilu.plus.common.request.Request;
import cn.pipilu.tensquare.search.request.AddArticleReq;
import cn.pipilu.tensquare.search.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tensquare-search/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/save")
    public void save(@RequestBody Request<AddArticleReq> reqData){

        articleService.save(reqData.getReqData());

    }

}
