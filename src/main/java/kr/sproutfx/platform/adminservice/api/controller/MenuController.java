package kr.sproutfx.platform.adminservice.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.sproutfx.platform.adminservice.api.model.Menu;
import kr.sproutfx.platform.adminservice.api.service.MenuService;
import kr.sproutfx.platform.adminservice.common.response.Result;

@RestController
@RequestMapping("/api/admin/menu")
public class MenuController {
    MenuService service;
    public MenuController (MenuService service) {
        this.service = service;
    }

    @GetMapping("tree-view")
    public Result<List<Menu>> selectForTreeView() {
        return new Result<>(service.selectForTreeView());
    }

    @GetMapping
    public Result<List<Menu>> selectByPId(@RequestParam String pId) {
        return new Result<>(service.selectByPId(pId));
    }
}
