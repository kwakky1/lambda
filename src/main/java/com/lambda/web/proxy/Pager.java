package com.lambda.web.proxy;

import com.lambda.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pager {
    @Autowired
    MovieMapper movieMapper;
    private int rowCount, startRow, endRow,
            pageCount, pageSize, startPage, endPage, nowPage,
            blockCount, blockSize, prevBlock, nextBlock, nowBlock;
    public void paging(){
        rowCount = movieMapper.count();
        pageSize = 5;
        pageCount = (rowCount%pageSize ==0) ? rowCount/pageSize :rowCount/pageSize+1;
        blockSize = 5;
        blockCount = (pageCount%blockSize ==0) ? pageCount/blockSize : pageCount/blockSize+1;
        nowPage = 1;
        startRow = 1+(pageSize*(nowPage-1));
        endRow = (nowBlock==pageCount)?rowCount:nowBlock*pageSize;
        nowBlock = nowPage/blockSize;
        startPage = 1+(blockSize*(nowPage-1));
        endPage = (nowBlock==pageCount)?pageCount:nowBlock*blockSize;
        prevBlock = startPage;

    }

}

