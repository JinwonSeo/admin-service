package kr.sproutfx.platform.adminservice.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.sproutfx.platform.adminservice.api.model.Enumeration;
import kr.sproutfx.platform.adminservice.api.service.EnumerationService;
import kr.sproutfx.platform.adminservice.common.response.Result;

@RestController
@RequestMapping("/api/admin/enumeration")
public class EnumerationController {
    EnumerationService service;

    @Autowired
    public EnumerationController(EnumerationService service) {
        this.service = service;
    }

    @GetMapping("/tree-view")
    public Result<List<Enumeration>> selectForTreeView() {
        return new Result<>(service.selectForTreeView());
    }

    @GetMapping("/{id}")
    public Result<Enumeration> selectById(@PathVariable String id) {
        return new Result<>(service.selectById(id));
    }

    @GetMapping
    public Result<List<Enumeration>> selectByPId(@RequestParam String pId) {
        return new Result<>(service.selectByPId(pId));
    }
    
    @PostMapping
    public Result<Enumeration> insert(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Enumeration enumeration) {
        return new Result<>(service.insert(
            Enumeration.builder()
                .nId(enumeration.getNId())
                .name(enumeration.getName())
                .sequence(enumeration.getSequence())
                .description(enumeration.getDescription())
                .isActive(enumeration.isActive())
                .isDefault(enumeration.isDefault())
                .pId(enumeration.getPId())
                .createUserId(userDetails.getUsername())
                .build()
        ));
    }

    @PutMapping
    public Result<Enumeration> update(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Enumeration enumeration) {
        return new Result<>(service.update(
            Enumeration.builder()
                .id(enumeration.getId())
                .nId(enumeration.getNId())
                .name(enumeration.getName())
                .sequence(enumeration.getSequence())
                .description(enumeration.getDescription())
                .isActive(enumeration.isActive())
                .isDefault(enumeration.isDefault())
                .lastUpdateUserId(userDetails.getUsername())
                .build()
        ));
    }

    @DeleteMapping("/{id}")
    public Result<Enumeration> delete(@AuthenticationPrincipal UserDetails userDetails, @PathVariable String id) {
        return new Result<>(service.delete(
            Enumeration.builder()
                .id(id)
                .deleteUserId(userDetails.getUsername())
                .build()
        ));
    }
}
