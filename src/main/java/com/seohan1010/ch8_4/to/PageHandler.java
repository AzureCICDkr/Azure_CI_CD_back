package com.seohan1010.ch8_4.to;

import org.springframework.web.util.UriComponentsBuilder;

import javax.sql.DataSource;

public class PageHandler {


//private int page; // 현재 페이지
//    private int pageSize; // 한 페이지의 크기
//    private String option;
//    private String keyword;


    private SearchCondition sc;


    private int totalCnt;  // 총 게시물 갯수
    private int naviSize = 10; // 페이지 네비게이션의 크기
    private int totalPage; // 전체 페이지의 개수

    private int beginPage; // 네비게이션의 첫번째 페이지
    private int endPage; // 네비게이션의 마지막 페이지
    private boolean showPrev; // 이전 페이지로 이동하는 링트를 보여줄 것인지의 여부
    private boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부


    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;


        doPaging(totalCnt,sc);
    }


    // 페이지를 지정해 주면은 아래의 메서드를 호출한다.

    public void doPaging(int totalCnt, SearchCondition sc) {

        this.totalCnt = totalCnt;

        totalPage = (int) Math.ceil(totalCnt / (double) sc.getPageSize());
        beginPage = ((sc.getPage() - 1) / naviSize) * naviSize + 1;
        // 아래의 식에서 왼쪽의 값은 언제나 10의 배수가 나온다. 반면 totalPage는
        // 왼쪽의 값보다 클수도 혹은 작을수도 있다.
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;

    }


    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }



    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }



    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    void print() {

        System.out.println("page = " + sc.getPage());
        System.out.println(showPrev ? "[PREV]" : "");
        for (int i = beginPage; i <= endPage; i++) {

            System.out.println(i + " ");
        }
        System.out.println(showNext ? "[NEXT]" : "");

    }


}
