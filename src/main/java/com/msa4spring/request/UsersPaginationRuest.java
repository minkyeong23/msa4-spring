package com.msa4spring.request;

public record UsersPaginationRuest(
    int page
    , int limit
) {
//    public UsersPaginationRuest(String page, String limit) {
//        this.page = (page == null)? "1" : page;
//        this.limit = (limit == null)? "10" : limit;
//    }
}
