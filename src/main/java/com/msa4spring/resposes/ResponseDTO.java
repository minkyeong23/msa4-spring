package com.msa4spring.resposes;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDTO<T> {
    private String code;
    private String msg;
    private T data;

}
