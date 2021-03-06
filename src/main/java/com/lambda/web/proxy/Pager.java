package com.lambda.web.proxy;

import com.lambda.web.mappers.MovieMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount, pageCount, blockCount,
            rowStart, pageStart, prevBlock,
            rowEnd, pageEnd, nextBlock,
            pageSize, blockSize,
            pageNow, blockNow;
    private boolean existPrev, existNext;
    private String searchWord;
    public void paging(){
        rowCount = movieMapper.count();
        rowStart = pageNow * pageSize; // 0
        rowEnd =(pageNow != pageCount-1)?rowStart + (pageSize-1): rowCount-1; // 4
        pageCount =(rowCount%pageSize !=0)?rowCount / pageSize + 1: rowCount / pageSize ; // 10
        pageStart = blockNow *  blockSize; // 0
        pageEnd =(blockNow != blockCount-1)? pageStart + (blockSize - 1): pageCount-1 ; // 4
        blockCount =(pageCount%blockSize !=0)?pageCount / blockSize + 1: pageCount / blockSize ; // 2
        prevBlock = pageStart - blockSize; // 0
        nextBlock = pageStart + blockSize; // 1
        blockNow = pageNow / blockSize; // 0
        existPrev = blockNow !=0;
        existNext = (blockNow+1) != blockCount;
    }
}
