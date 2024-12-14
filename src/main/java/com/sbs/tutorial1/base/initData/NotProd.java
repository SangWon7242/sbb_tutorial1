package com.sbs.tutorial1.base.initData;

import com.sbs.tutorial1.base.rq.Rq;
import com.sbs.tutorial1.boundedContext.article.service.ArticleService;
import com.sbs.tutorial1.boundedContext.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "test"})
// Production(운영 환경, 라이브 서버)이 아니다.
// NotProd : 개발환경이 아니고, 테스트 환경이 아닐때만 실행
public class NotProd {
  @Bean
  CommandLineRunner initData(MemberService memberService, ArticleService articleService) {
    return args -> {
      // 이 부분은 스프링부트 앱이 실행되고, 본격적으로 작동하기 전에 실행된다.
      memberService.join("user1", "1234");
      memberService.join("abc", "123456");
      memberService.join("test", "1222");
      memberService.join("bbc", "1111");
      memberService.join("love", "5555");
      memberService.join("hello", "123478");
      memberService.join("user2", "12596");
      memberService.join("user3", "33333");
      memberService.join("good", "456732");
      memberService.join("like", "123444");

      articleService.write("제목1", "내용1");
      articleService.write("제목2", "내용2");
    };
  }
}
