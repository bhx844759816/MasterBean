package com.bhx.masterbean.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bhx.common.mvvm.BaseMVVMActivity;
import com.bhx.common.ui.widget.FlowLayout;
import com.bhx.common.utils.DensityUtil;
import com.bhx.common.utils.LogUtils;
import com.bhx.masterbean.R;
import com.bhx.masterbean.config.Constants;
import com.bhx.masterbean.model.article.ArticleDetailModel;
import com.bhx.masterbean.vm.ArticleDetailViewModel;
import com.just.agentweb.AgentWeb;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 文章详情界面
 */
public class ArticleDetailActivity extends BaseMVVMActivity<ArticleDetailViewModel> {

    @BindView(R.id.id_article_type)
    TextView mArticleType;
    @BindView(R.id.id_article_title)
    TextView mArticleTitle;
    @BindView(R.id.id_article_tag)
    FlowLayout mArticleTag;
    @BindView(R.id.id_article_collection_num)
    TextView mArticleCollectionNum;
    @BindView(R.id.id_article_look_num)
    TextView mArticleLookNum;
    @BindView(R.id.id_article_webView)
    FrameLayout mArticleWebView;
    WebView mWebView;
    @BindView(R.id.id_article_topBar)
    RelativeLayout idArticleTopBar;
    @BindView(R.id.id_article_message)
    TextView mArticleMessage;
    @BindView(R.id.id_article_click)
    TextView mArticleClick;
    @BindView(R.id.id_article_share)
    TextView mArticleShare;

    private AgentWeb mAgentWeb;

    @Override
    protected Object getEventKey() {
        return Constants.EVENT_KEY_ARTICLE_DETAIL;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        mWebView = new WebView(this);
        mWebView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        mWebView.getSettings().setAllowFileAccess(true); //设置可以访问文件
        mWebView.getSettings().setBlockNetworkImage(true);
        mWebView.getSettings().setLoadsImagesAutomatically(true); //支持自动加载图片
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mWebView.getSettings().setBlockNetworkImage(false);
            }
        });
        mArticleWebView.addView(mWebView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
            mWebView.getSettings().setJavaScriptEnabled(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
            mWebView.getSettings().setJavaScriptEnabled(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mArticleWebView.removeView(mWebView);
        if (mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
    }

    @Override
    protected void initData() {
        String articleId = getIntent().getStringExtra("article_id");
        mViewModel.getArticleDetail(articleId);
    }

    @Override
    protected void dataObserver() {
        super.dataObserver();
        registerObserver(Constants.TAG_ARTICLE_DETAIL, ArticleDetailModel.class)
                .observe(this, articleDetailModel -> {
                    if (articleDetailModel != null) {
                        mArticleTitle.setText(articleDetailModel.getTitle());
                        mArticleLookNum.setText(articleDetailModel.getView_num());
                        mArticleCollectionNum.setText(articleDetailModel.getColect_num());
                        initTags(articleDetailModel);
                        loadWebView(articleDetailModel);
                    }
                });
    }

    private void loadWebView(ArticleDetailModel model) {
        //替换img属性
        String imgJs = "<script type='text/javascript'> window.onload = function(){var $img = document.getElementsByTagName('img');for(var p in  $img){$img[p].style.maxWidth = '100%'; $img[p].style.height ='auto'}}</script>";
        mWebView.loadDataWithBaseURL(null, imgJs + model.getContent(), "text/html", "utf-8", null);
    }

    private void initTags(ArticleDetailModel model) {
        mArticleTag.removeAllViews();
        List<ArticleDetailModel.TagIdBean> tagIds = model.getTag_id();
        if (tagIds != null) {
            for (ArticleDetailModel.TagIdBean tagId : tagIds) {
                LogUtils.i("tagId:" + tagId.getTag_name());
                addView(tagId.getTag_name());
            }
        }
    }

    private void addView(String text) {
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.rightMargin = DensityUtil.dip2px(this, 8);
        lp.bottomMargin = DensityUtil.dip2px(this, 8);
        TextView view = new TextView(this);
        view.setTextSize(10);
        view.setText(text);
        view.setTextColor(getResources().getColor(R.color.text_default));
        view.setBackground(getResources().getDrawable(R.drawable.drawable_flow_label));
        mArticleTag.addView(view, lp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
