package com.wisely.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
@EnableScheduling
public class AysncService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
    	System.out.println("getAsyncUpdate....");
    	deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh() {
    	System.out.println("refresh....");
        if (deferredResult != null) {
            deferredResult.setResult(new Long(System.currentTimeMillis())
                    .toString());
        }
    }


}