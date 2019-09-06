package cn.pipilu.tensquare.search.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
@Document(indexName = "tensquarearticle",type = "article")
@Data
@ToString
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 2137390090289395720L;

    @Id
    private String id;
    //是否索引，意味着该字段是否能被搜索e
    //是否分词，意味着搜索的时候该域是整体匹配，还是单词匹配
    //是否存储，意味着是否在页面上展示
    @Field(index = true,store = true,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String content;
    @Field(index = true,store = true,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String title;
    private String state;
}
