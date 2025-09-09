package gc.board.article;

import gc.board.article.entity.Article;
import gc.board.article.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void findAllTest() {
        Long boardId = 1L;
        Long offset = 1499970L;
        Long limit = 30L;

        List<Article> articles = articleRepository.findAll(boardId, offset, limit);

        log.info("조회된 아티클 수: {}", articles.size());
        
        for (Article article : articles) {
            log.info("Article ID: {}, Title: {}, BoardId: {}, WriterId: {}, CreatedAt: {}", 
                    article.getArticleId(), 
                    article.getTitle(), 
                    article.getBoardId(), 
                    article.getWriterId(), 
                    article.getCreatedAt());
        }
    }
}
