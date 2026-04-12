package com.fisslink.backend.services;

import com.fisslink.backend.data.models.URL;
import com.fisslink.backend.data.repositories.URLRepository;
import com.fisslink.backend.dtos.requests.ShortCodeRequestDto;
import com.fisslink.backend.dtos.requests.UrlRequestDto;
import com.fisslink.backend.dtos.responses.ShortCodeResponseDto;
import com.fisslink.backend.dtos.responses.UrlResponseDto;
import com.fisslink.backend.exceptions.NonExistingShortCodeException;
import com.fisslink.backend.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {
    @Autowired
    private URLRepository urlRepository;

    public ShortCodeResponseDto shortUrl(UrlRequestDto requestDto){
        if (urlRepository.existsByOriginalUrl(requestDto.getOriginalUrl())){
            URL oldUrl = urlRepository.findByOriginalUrl(requestDto.getOriginalUrl());
            return Mappers.shortCodeResponse(oldUrl);
        }

        URL newUrl = Mappers.urlRequest(requestDto);
        if(urlRepository.existsByShortCode(newUrl.getShortCode())){
            newUrl = Mappers.urlRequest(requestDto);
        }
        urlRepository.save(newUrl);
        return Mappers.shortCodeResponse(newUrl);
    }

    public UrlResponseDto getOriginalUrl(ShortCodeRequestDto requestDto){
        if(urlRepository.existsByShortCode(requestDto.getShortCode())){
            URL oldUrl = urlRepository.findByShortCode(requestDto.getShortCode());
            return Mappers.urlResponse(oldUrl);
        }
        else throw new NonExistingShortCodeException("Sorry, this short code does not exist");
    }
}
