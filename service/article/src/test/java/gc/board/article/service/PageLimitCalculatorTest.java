package gc.board.article.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PageLimitCalculatorTest {

    @Test
    void calculatePageLimitTest() {
        // 첫 번째 그룹 (페이지 1~10)
        calculatePageLimitTest(1L, 30L, 10L, 301L);
        calculatePageLimitTest(7L, 30L, 10L, 301L);
        calculatePageLimitTest(10L, 30L, 10L, 301L);
        
        // 두 번째 그룹 (페이지 11~20)
        calculatePageLimitTest(11L, 30L, 10L, 601L);
        calculatePageLimitTest(12L, 30L, 10L, 601L);
    }

    private void calculatePageLimitTest(Long page, Long pageSize, Long movablePageCount, Long expected) {
        // given & when
        Long actual = PageLimitCalculator.calculatePageLimit(page, pageSize, movablePageCount);
        
        // then
        assertThat(actual).isEqualTo(expected);
    }
}
