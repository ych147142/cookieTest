package com.neuedu.pojo;

import java.util.List;

public class ResultData {
    private List<?> lists;
    private int pageNo;//页码
    private int pageSize;//每页数据条数
    private String pageView;//分页条
    private int maxPage;//最大页数
    private int maxCount;//数据最大条数
    private String url;//跳转地址

    /**
     * 拼接分页条
     * @param url
     */
    public void setUrl(String url){
        this.url = url;
        StringBuilder strb = new StringBuilder();
        if (pageNo == 1) {
            strb.append("<li class='page'><a href='javascript:void(0)'>首页</a> </li>");
            strb.append("<li class='page'><a href='javascript:void(0)'>上一页</a> </li>");
        }else{
            strb.append("<li class='page'><a href='"+url+"?pageNo=1'>首页</a> </li>");
            strb.append("<li class='page'><a href='"+url+"?pageNo="+(pageNo-1)+"'>上一页</a> </li>");
        }
        for (int i = 1 ;i <= maxPage ;i++){
            if (i == pageNo){
                strb.append("<li class='page1'><a href='javascript:void(0)'>"+pageNo+"</a> </li>");
            }else {
                strb.append("<li class='page1'><a href='"+url+"?pageNo="+i+"'>"+i+"</a> </li>");
            }
        }

        if (pageNo == maxPage){
            strb.append("<li class='page'><a href='javascript:void(0)'>下一页</a> </li>");
            strb.append("<li class='page'><a href='javascript:void(0)'>尾页</a> </li>");
        }else{
            strb.append("<li class='page'><a href='"+url+"?pageNo="+(pageNo+1)+"'>下一页</a> </li>");
            strb.append("<li class='page'><a href='"+url+"?pageNo="+maxPage+"'>尾页</a> </li>");
        }
        this.pageView = strb.toString();
    }
    public String getPageView(){
        return pageView;
    }


    public List<?> getLists() {
        return lists;
    }

    public void setLists(List<?> lists) {
        this.lists = lists;
    }

    public ResultData(int pageNo, int pageSize, int maxCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.maxCount = maxCount;
        this.maxPage = maxCount % pageSize == 0 ? maxCount/pageSize : maxCount/pageSize + 1;

    }
}
