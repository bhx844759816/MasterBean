package com.bhx.masterbean.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.bhx.common.mvvm.BaseViewModel;
import com.bhx.masterbean.vm.repository.ArticleDetailRepository;

public class ArticleDetailViewModel extends BaseViewModel<ArticleDetailRepository> {

    public ArticleDetailViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 获取文章详情
     */
    public void getArticleDetail(String articleId) {
        mRepository.getArticleDetail(articleId);
    }

    /**
     * 获取观看人数列表
     */
    public void getViewNum() {
        mRepository.getViewNum();
    }

    /**
     * 获取收藏列表
     */
    public void getCollectionNum() {
        mRepository.getCollectionNum();
    }

    /**
     * 获取消息列表
     */
    public void getMessageList() {
        mRepository.getMessageList();
    }
}
