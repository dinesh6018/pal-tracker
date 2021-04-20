package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String memLimit;
    private final String index;
    private final String addr;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memLimit,
                         @Value("${cf.instance.index:NOT SET}") String index,
                         @Value("${cf.instance.addr:NOT SET}") String addr) {
        this.port = port;
        this.memLimit = memLimit;
        this.index = index;
        this.addr = addr;
    }

    @GetMapping("/env")
    public Map<String,String> getEnv() {
        Map<String, String> envVar =  new HashMap<>();
        envVar.put("PORT", port);
        envVar.put("MEMORY_LIMIT", memLimit);
        envVar.put("CF_INSTANCE_INDEX", index);
        envVar.put("CF_INSTANCE_ADDR", addr);
        return envVar;
    }

}
