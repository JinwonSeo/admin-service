package kr.sproutfx.platform.adminservice.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.sproutfx.platform.adminservice.api.model.Menu;

@Mapper
public interface MenuMapper {
    List<Menu> selectForTreeView();

    List<Menu> selectByPId(String pId);
}
