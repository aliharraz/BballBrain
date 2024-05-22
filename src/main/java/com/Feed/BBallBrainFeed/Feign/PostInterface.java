package com.Feed.BBallBrainFeed.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("USER-SERVICE")
public interface PostInterface {
}
