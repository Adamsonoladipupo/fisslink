package com.fisslink.backend.controllers;

import com.fisslink.backend.dtos.requests.ShortCodeRequestDto;
import com.fisslink.backend.dtos.requests.UrlRequestDto;
import com.fisslink.backend.dtos.responses.ShortCodeResponseDto;
import com.fisslink.backend.dtos.responses.UrlResponseDto;
import com.fisslink.backend.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin("*")
@RestController
public class URLController {
    @Autowired
    private URLService urlService;

    @PostMapping("/shortenUrl")
    public ResponseEntity<String> shortenedUrl(@RequestBody UrlRequestDto requestDto){
        ShortCodeResponseDto responseDto = urlService.shortUrl(requestDto);
        return ResponseEntity.ok(responseDto.getShortCode());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable("shortCode") ShortCodeRequestDto shortCode){
        UrlResponseDto originalUrl = urlService.getOriginalUrl(shortCode);
        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl.getOriginalUrl()))
                .build();
    }
}
