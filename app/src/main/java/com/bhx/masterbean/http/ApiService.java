package com.bhx.masterbean.http;

import com.bhx.common.http.BaseResponse;
import com.bhx.masterbean.model.article.ArticleDetailModel;
import com.bhx.masterbean.model.home.BannerModel;
import com.bhx.masterbean.model.home.HomeModel;

import java.util.List;
import java.util.Map;
import java.util.Observer;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 所有接口的请求类
 */
public interface ApiService {
    /**
     * 获取验证码
     *
     * @param phone
     * @return
     */
    @FormUrlEncoded
    @POST("Home/Login/sendPhone")
    Observable<BaseResponse<String>> getCheckedCode(@Field("tel") String phone);


    /**
     * 获取首页列表数据
     *  city=%E9%83%91%E5%B7%9E&pageid=3
     * @return
     */
    @FormUrlEncoded
    @POST("Home/Index/index")
    Observable<BaseResponse<List<HomeModel>>> getHomeModel(@Field("city") String city,@Field("pageid") String pages);

    /**
     * 获取首页banner数据
     *
     * @return
     */
    @POST("Home/Index/slideshow")
    Observable<BaseResponse<List<BannerModel>>> getBannerModel();

    /**
     * 获取资讯详情
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("home/Index/activity")
    Observable<BaseResponse<ArticleDetailModel>> getArticleDetailModel(@FieldMap Map<String, String> params);



    //搜索接口  http://47.105.85.110/index.php/Home/Index/search
    //发送验证码 http://47.105.85.110/index.php/Home/Login/sendPhone
    //频道接口  http://47.105.85.110//index.php/home/column/colArticle
    //回复消息  http://47.105.85.110/index.php/home/message/comment
    //文章详情  http://47.105.85.110/index.php/home/Index/activity
    //观看人数  http://app.jxd007.cn/index.php/home/article/view_num
    //活动包名列表   http://app.jxd007.cn/index.php/home/article/commentlist
    //收藏列表     http://app.jxd007.cn/index.php/home/article/collectLists
    //匠豆等级  http://app.jxd007.cn/index.php/home/coin/goldLev
    //匠豆排行 http://app.jxd007.cn/index.php/home/coin/gold
}
