package com.bhx.masterbean.model.home;

import java.util.List;

/**
 * 首页面布局
 */
public class HomeModel {

    /**
     * id : 909
     * title : 哈佛大学研究：一个人成为废物的九大根源
     * img : /data/2019-03-29/5c9d8953a6fab.jpg
     * author : 开个书店吧
     * view_num : 11
     * click_num : 3
     * colect_num : 2
     * share_num : 0
     * is_top : 1
     * is_new : 0
     * is_recom : 1
     * column_id : 1
     * tag_id : [{"id":"357","tag_name":"学习力","addtime":"1540793614","hot":"0"},{"id":"368","tag_name":"灵机一动","addtime":"1548382483","hot":"0"},{"id":"370","tag_name":"小小人物","addtime":"1548390444","hot":"1"},{"id":"372","tag_name":"观点分析","addtime":"1551601768","hot":"0"}]
     * city_id : 149
     * addtime : 1553828794
     * address :
     * people_num : 0
     * people_sum : 0
     * cost : 0.00
     * start_time :
     * end_time :
     * channel_id : 1
     * apply_sts : 1
     * notice :
     * activity_type : 0
     * vip1_dis : 0
     * vip2_dis : 0
     * vip3_dis : 0
     * earnings : 0
     * describ :
     */

    private String id; //id
    private String title; //文章标题
    private String img; // 图片
    private String author; //作者
    private String view_num;//有多少人看
    private String click_num;//有多少点赞
    private String colect_num;//收藏的人数
    private String share_num; //分享的人数
    private String is_top; // 是否在顶端
    private String is_new; // 是否是新消息
    private String is_recom;//
    private String column_id;
    private String city_id;
    private String addtime;
    private String address;
    private String people_num;
    private String people_sum;
    private String cost;
    private String start_time;
    private String end_time;
    private String channel_id;
    private String apply_sts;
    private String notice;
    private String activity_type;
    private String vip1_dis;
    private String vip2_dis;
    private String vip3_dis;
    private String earnings;
    private String describ;
    private List<TagIdBean> tag_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getView_num() {
        return view_num;
    }

    public void setView_num(String view_num) {
        this.view_num = view_num;
    }

    public String getClick_num() {
        return click_num;
    }

    public void setClick_num(String click_num) {
        this.click_num = click_num;
    }

    public String getColect_num() {
        return colect_num;
    }

    public void setColect_num(String colect_num) {
        this.colect_num = colect_num;
    }

    public String getShare_num() {
        return share_num;
    }

    public void setShare_num(String share_num) {
        this.share_num = share_num;
    }

    public String getIs_top() {
        return is_top;
    }

    public void setIs_top(String is_top) {
        this.is_top = is_top;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getIs_recom() {
        return is_recom;
    }

    public void setIs_recom(String is_recom) {
        this.is_recom = is_recom;
    }

    public String getColumn_id() {
        return column_id;
    }

    public void setColumn_id(String column_id) {
        this.column_id = column_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPeople_num() {
        return people_num;
    }

    public void setPeople_num(String people_num) {
        this.people_num = people_num;
    }

    public String getPeople_sum() {
        return people_sum;
    }

    public void setPeople_sum(String people_sum) {
        this.people_sum = people_sum;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getApply_sts() {
        return apply_sts;
    }

    public void setApply_sts(String apply_sts) {
        this.apply_sts = apply_sts;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public String getVip1_dis() {
        return vip1_dis;
    }

    public void setVip1_dis(String vip1_dis) {
        this.vip1_dis = vip1_dis;
    }

    public String getVip2_dis() {
        return vip2_dis;
    }

    public void setVip2_dis(String vip2_dis) {
        this.vip2_dis = vip2_dis;
    }

    public String getVip3_dis() {
        return vip3_dis;
    }

    public void setVip3_dis(String vip3_dis) {
        this.vip3_dis = vip3_dis;
    }

    public String getEarnings() {
        return earnings;
    }

    public void setEarnings(String earnings) {
        this.earnings = earnings;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public List<TagIdBean> getTag_id() {
        return tag_id;
    }

    public void setTag_id(List<TagIdBean> tag_id) {
        this.tag_id = tag_id;
    }

    public static class TagIdBean {
        /**
         * id : 357
         * tag_name : 学习力
         * addtime : 1540793614
         * hot : 0
         */

        private String id;
        private String tag_name;
        private String addtime;
        private String hot;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }
    }
}
