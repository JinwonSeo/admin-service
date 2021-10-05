package kr.sproutfx.platform.adminservice.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.sproutfx.platform.adminservice.api.mapper.MenuMapper;
import kr.sproutfx.platform.adminservice.api.model.Menu;

@Service
public class MenuService {
    MenuMapper mapper;

    @Autowired
    public MenuService(MenuMapper mapper) {
        this.mapper = mapper;        
    }

    public List<Menu> selectForTreeView() {
        return mapper.selectForTreeView();
    }

    public List<Menu> selectByPId(String pId) {
        return mapper.selectByPId(pId);
    }
}
