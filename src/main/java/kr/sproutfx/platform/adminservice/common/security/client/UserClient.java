package kr.sproutfx.platform.adminservice.common.security.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.sproutfx.platform.adminservice.common.security.model.User;

@FeignClient(
    name = "platform-gateway-service",
    url = "${sproutfx.platform.gateway.url}"
)
public interface UserClient {
    @GetMapping("/api/auth/common/security/user/{id}")
    User selectById(@PathVariable String id);
}