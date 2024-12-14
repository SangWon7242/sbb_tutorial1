package com.sbs.tutorial1.boundedContext.article.controller;

import com.sbs.tutorial1.base.rsData.RsData;
import com.sbs.tutorial1.boundedContext.article.entity.Article;
import com.sbs.tutorial1.boundedContext.article.repository.ArticleRepository;
import com.sbs.tutorial1.boundedContext.article.service.ArticleService;
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
  private final ArticleService articleService;

  @GetMapping("/write")
  @ResponseBody
  public RsData write(String subject, String content) {
    if(subject == null || subject.trim().isEmpty()) {
      return RsData.of("F-1", "subject(을)를 입력해주세요.");
    }

    if(content == null || content.trim().isEmpty()) {
      return RsData.of("F-2", "content(을)를 입력해주세요.");
    }

    Article createArticle = articleService.write(subject, content);

    return RsData.of("S-1", "%d번 글이 생성되었습니다.".formatted(createArticle.getId()), createArticle);
  }
}
