package kr.sproutfx.platform.adminservice.api.controller;

import kr.sproutfx.platform.adminservice.api.service.MenuAndProgramService;
import kr.sproutfx.platform.adminservice.api.model.MenuAndProgram;
import kr.sproutfx.platform.adminservice.common.response.Result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/menu-and-program")
public class MenuAndProgramController {
    MenuAndProgramService service;

    @Autowired
    public MenuAndProgramController(MenuAndProgramService service) {
        this.service = service;
    }

    @GetMapping
    public Result<List<MenuAndProgram>> selectByMenuPId(@RequestParam String menuPId) {
        return new Result<>(service.selectByMenuPId(menuPId));
    }
}
