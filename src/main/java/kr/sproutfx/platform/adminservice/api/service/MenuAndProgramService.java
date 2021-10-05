package kr.sproutfx.platform.adminservice.api.service;

import java.util.List;

import kr.sproutfx.platform.adminservice.api.mapper.MenuAndProgramMapper;
import kr.sproutfx.platform.adminservice.api.model.MenuAndProgram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuAndProgramService {
    MenuAndProgramMapper mapper;

    @Autowired
    public MenuAndProgramService(MenuAndProgramMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
	public List<MenuAndProgram> selectByMenuPId(String menuPId) {
		return mapper.selectByMenuPId(menuPId);
    }
}
