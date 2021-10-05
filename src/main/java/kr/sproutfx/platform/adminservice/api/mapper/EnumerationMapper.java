package kr.sproutfx.platform.adminservice.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.sproutfx.platform.adminservice.api.model.Enumeration;

@Mapper
public interface EnumerationMapper {
    Enumeration selectById(String id);
    Enumeration selectByNId(String nId);
    List<Enumeration> selectByPId(String pId);
    List<Enumeration> selectForTreeView();
    int insert(Enumeration build);
    int update(Enumeration target);
    int delete(Enumeration build);
}
