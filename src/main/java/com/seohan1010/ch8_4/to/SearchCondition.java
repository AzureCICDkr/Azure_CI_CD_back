package com.seohan1010.ch8_4.to;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

public class SearchCondition {

    private String option = "";
    private String keyword = "";
    private Integer page = 1;
    private Integer pageSize = 10;



    public SearchCondition() {
    }

    public SearchCondition(String option,String keyword) {
        this(option,keyword,1,10);
    }



    public SearchCondition(String option, String keyword, Integer page, Integer pageSize) {
        this.option = option;
        this.keyword = keyword;
        this.page = page;
        this.pageSize = pageSize;
    }


    @Override
    public String toString() {
        return "SearchCondition{" +
                "option='" + option + '\'' +
                ", keyword='" + keyword + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCondition that = (SearchCondition) o;
        return Objects.equals(option, that.option) && Objects.equals(keyword, that.keyword) && Objects.equals(page, that.page) && Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(option, keyword, page, pageSize);
    }






// 현 프로젝트는 rest api를 사용하기 때문에 아래의 코드는 유효하지 않다.
    public String getQueryString(Integer page){

        return  UriComponentsBuilder.newInstance()
                .queryParam("page",page)
                .queryParam("pageSize",pageSize)
                .queryParam("option",option)
                .queryParam("keyword",keyword)
                .build().toString();

    }



    //iv가 없더라도 mybatis에서는 getOffset을 호출하므로 이 메서드가 필요하다.
    public Integer getOffset() {
        return (page-1)*pageSize;
    }



    //페이지를 지정하지 않으면 아래의 메서드를 호출하게 하고
    public String getQueryString(){
        return getQueryString(page);
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
