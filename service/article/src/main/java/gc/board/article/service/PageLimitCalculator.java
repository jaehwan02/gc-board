package gc.board.article.service;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class PageLimitCalculator {

    public static Long calculatePageLimit(Long page, Long pageSize, Long movablePageCount) {
        Long pageLimit = (((page - 1) / movablePageCount) + 1) * pageSize * movablePageCount + 1;
        return pageLimit;
    }
}
