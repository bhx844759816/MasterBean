package com.bhx.masterbean.vm.repository;

import com.bhx.common.http.RxHelper;
import com.bhx.masterbean.MyApplication;
import com.bhx.masterbean.config.Constants;

import java.util.HashMap;
import java.util.Map;


public class ArticleDetailRepository extends BaseEventRepository {
    /**
     * 获取文章详情
     */
    public void getArticleDetail(String articleId) {
        Map<String, String> map = new HashMap<>();
        map.put("id", articleId);
        map.put("user_token", MyApplication.token);
        addDisposable(apiService.getArticleDetailModel(map)
                .compose(RxHelper.handleResult())
                .subscribe(articleDetailModel ->
                        sendData(Constants.EVENT_KEY_ARTICLE_DETAIL, Constants.TAG_ARTICLE_DETAIL, articleDetailModel)));
    }

    /**
     * 获取观看人数列表
     */
    public void getViewNum() {

    }

    /**
     * 获取收藏列表
     */
    public void getCollectionNum() {

    }

    /**
     * 获取消息列表
     */
    public void getMessageList() {

    }
}
