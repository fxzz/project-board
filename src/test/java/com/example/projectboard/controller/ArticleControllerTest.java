package com.example.projectboard.controller;

import io.micrometer.core.instrument.binder.http.HttpRequestTags;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    @Autowired
    private MockMvc mvc;


    @DisplayName("[view][GET] 게시글 리스트 (게시판) 페이지 - 정상호출")
    @Test
    public void 게시글_리스트_정상_호출() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));
    }

    @DisplayName("[view][GET] 게시글 상세 페이지 - 정상호출")
    @Test
    public void 게시글_상시_페이지_정상_호출() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));
    }

    @DisplayName("[view][GET] 게시글 검색 전용 페이지 - 정상호출")
    @Test
    public void 게시글_검색_전용_페이지_정상_호출() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

    @DisplayName("[view][GET] 게시글 헤시태그 검색 페이지 - 정상호출")
    @Test
    public void 게시글_헤시태그_검색_페이지_정상_호출() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

}