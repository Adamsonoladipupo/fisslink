package com.fisslink.backend.utils;

import com.fisslink.backend.data.models.URL;
import com.fisslink.backend.dtos.requests.UrlRequestDto;
import com.fisslink.backend.dtos.responses.ShortCodeResponseDto;
import com.fisslink.backend.dtos.responses.UrlResponseDto;

import java.time.LocalDateTime;

public class Mappers {
    public static URL urlRequest(UrlRequestDto requestDto){
        URL url = new URL();
        url.setOriginalUrl(requestDto.getOriginalUrl());
        url.setShortCode(CodeGenerator.generate());
        url.setCreatedAt(LocalDateTime.now());
        return url;
    }

    public static ShortCodeResponseDto shortCodeResponse(URL url ){
        ShortCodeResponseDto responseDto =  new ShortCodeResponseDto();
        responseDto.setShortCode(url.getShortCode());
        return responseDto;
    }

    public static UrlResponseDto urlResponse(URL url){
        UrlResponseDto responseDto = new UrlResponseDto();
        responseDto.setOriginalUrl(url.getOriginalUrl());
        return responseDto;
    }
}
