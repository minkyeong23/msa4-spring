package com.msa4spring.controllers;

import com.msa4spring.request.PostsFilterRequest;
import com.msa4spring.request.UsersPaginationRuest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {
    @GetMapping("/users")
    public String index(
        @RequestParam(required = false, defaultValue = "1") String page
        , @RequestParam String limit
    ) {
        // 쿼리 파미터 획득 방법: @RequestParam 어노테이션을 통해 획득
        return "GET Users: " + page + ", " + limit;
    }

    @GetMapping("/users/{id}")
    public String show(
        @PathVariable String id
    ) {
        return "GET users show: " + id;
    }

    @PostMapping("/users")
    public String store() {
        return "POST Users";
    }

//------------------------------
// DTO를 활용하여 파라미터 획득
//------------------------------
@GetMapping("/users/dto-param")
    public String dtoParam(
        UsersPaginationRuest usersPaginationRuest
) {
        return String.format("GET dtoParam: %s, %s", usersPaginationRuest.page(), usersPaginationRuest.limit());
}
// --- 세그먼트 파라미터를 || Form Data를 DTO로 획득
//    @ModelAttribute 사용
    @GetMapping("/posts/{id}/filter/{categoryId}")
    public String postFilter(@ModelAttribute PostsFilterRequest postsFilterRequest) {
        return String.format(
            "postFilter: %d, %d"
            ,postsFilterRequest.id()
            ,postsFilterRequest.categoryId()
            );
    }

    // JSON 데이터를 DTO로 획득
    @GetMapping("/posts/json")
    public String postsJson(
        @RequestBody PostsFilterRequest postsFilterRequest
    ) {
        return String.format(
            "postJson: %d, %d"
            ,postsFilterRequest.id()
            ,postsFilterRequest.categoryId()
        );
    }
}
