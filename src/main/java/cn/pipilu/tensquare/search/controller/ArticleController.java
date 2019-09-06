package cn.pipilu.tensquare.search.controller;

import cn.pipilu.plus.common.request.Request;
import cn.pipilu.plus.common.response.Response;
import cn.pipilu.plus.common.util.ResponseUtil;
import cn.pipilu.tensquare.search.request.AddArticleReq;
import cn.pipilu.tensquare.search.request.QueryArticleReq;
import cn.pipilu.tensquare.search.response.QueryArticleResp;
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
    @Autowired
    private ResponseUtil responseUtil;
    @RequestMapping("/save")
    public Response<Void> save(@RequestBody Request<AddArticleReq> reqData){
        Response<Void> response = new Response<>();
        try {
            articleService.save(reqData.getReqData());
            responseUtil.setRespParam(response);
        }catch (Exception e){
            responseUtil.setRespParam(response,e);
        }
        return response;
    }

    @RequestMapping("/findByKeyword")
    public Response<QueryArticleResp> findByKeyword(@RequestBody Request<QueryArticleReq> reqData){
        Response<QueryArticleResp> response = new Response<>();
        try {
            response.setRespData(articleService.findByKeyword(reqData.getReqData()));
            responseUtil.setRespParam(response);
        }catch (Exception e){
            responseUtil.setRespParam(response,e);
        }
        return response;
    }

}
