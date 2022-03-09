package resilience.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import resilience.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service test ID = "+id);
    }
}
