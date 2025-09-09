package gc.board.article.api;

import gc.board.article.service.response.ArticleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

public class ArticleApiTest {
  RestClient restClient = RestClient.create("http://localhost:9000");
  private Long createdArticleId;

  @Test
  void createTest() {
    ArticleResponse response = create(new ArticleCreateRequest(
            "hi", "my content", 1L, 1L
    ));
    this.createdArticleId = response.getArticleId();
    System.out.println("response = " + response);
    System.out.println("Created Article ID: " + createdArticleId);
  }

  ArticleResponse create(ArticleCreateRequest request) {
    return restClient.post()
            .uri("/v1/articles")
            .body(request)
            .retrieve()
            .body(ArticleResponse.class);
  }

  @Test
  void readTest() {
    if (createdArticleId == null) {
      createTest(); // 먼저 article 생성
    }
    ArticleResponse response = read(createdArticleId);
    System.out.println("response = " + response);
  }

  ArticleResponse read(Long articleId) {
    return restClient.get()
            .uri("/v1/articles/{articleId}", articleId)
            .retrieve()
            .body(ArticleResponse.class);
  }

  @Test
  void updateTest() {
    if (createdArticleId == null) {
      createTest(); // 먼저 article 생성
    }
    update(createdArticleId);
    ArticleResponse response = read(createdArticleId);
    System.out.println("response = " + response);
  }

  void update(Long articleId) {
    restClient.put()
            .uri("/v1/articles/{articleId}", articleId)
            .body(new ArticleUpdateRequest("hi 2", "my content 2"))
            .retrieve();
  }

  @Test
  void deleteTest() {
    if (createdArticleId == null) {
      createTest(); // 먼저 article 생성
    }
    restClient.delete()
            .uri("/v1/articles/{articleId}", createdArticleId)
            .retrieve();
    System.out.println("Deleted Article ID: " + createdArticleId);
  }

  @Getter
  @AllArgsConstructor
  static class ArticleCreateRequest {
    private String title;
    private String content;
    private Long boardId;
    private Long writerId;
  }

  @Getter
  @AllArgsConstructor
  static class ArticleUpdateRequest {
    private String title;
    private String content;
  }

}
