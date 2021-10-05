package kr.sproutfx.platform.adminservice.api.mapper;

import java.util.List;

import kr.sproutfx.platform.adminservice.api.model.MenuAndProgram;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuAndProgramMapper {
    List<MenuAndProgram> selectByMenuPId(String menuPId);
}
