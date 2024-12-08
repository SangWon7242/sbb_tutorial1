package com.sbs.tutorial1.boundedContext.article.controller;

import com.sbs.tutorial1.base.rsData.RsData;
import com.sbs.tutorial1.boundedContext.article.entity.Article;
import com.sbs.tutorial1.boundedContext.article.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor // 필드 중에서 final 붙은 것만 인자로 입력받는 생성자 생성
public class ArticleController {
  private final ArticleRepository articleRepository;

  @GetMapping("/write")
  @ResponseBody
  public RsData write(String subject, String content) {
    Article article = Article
        .builder()
        .createDate(LocalDateTime.now())
        .modifyDate(LocalDateTime.now())
        .subject(subject)
        .content(content)
        .build();

    articleRepository.save(article); // insert, update 쿼리 실행

    /*
    Article article = new Article(subject, content);

    Article article = new Article();
    article.setSubject(subject);
    article.setContent(content);
    */

    return RsData.of("S-1", "%d번 글이 생성되었습니다.".formatted(article.getId()), article);
  }
}
