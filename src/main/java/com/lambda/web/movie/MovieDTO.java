package com.lambda.web.movie;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class MovieDTO {
    private String rank, title, rankDate;
}
