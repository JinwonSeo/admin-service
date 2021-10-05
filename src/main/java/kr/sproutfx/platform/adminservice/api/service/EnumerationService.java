package kr.sproutfx.platform.adminservice.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.sproutfx.platform.adminservice.api.mapper.EnumerationMapper;
import kr.sproutfx.platform.adminservice.api.model.Enumeration;
import kr.sproutfx.platform.adminservice.common.exception.AlreadyInUseException;
import kr.sproutfx.platform.adminservice.common.exception.UnprocessableEntityException;

@Service
@Transactional
public class EnumerationService {
    EnumerationMapper mapper;

    @Autowired
    public EnumerationService(EnumerationMapper mapper) {
        this.mapper = mapper;
    }

    public List<Enumeration> selectForTreeView() {
        return mapper.selectForTreeView();
    }

    public Enumeration selectById(String id) {
        return mapper.selectById(id);
    }

    public Enumeration selectByNId(String nId) {
        return mapper.selectByNId(nId);
    }

    public List<Enumeration> selectByPId(String pId) {
        return mapper.selectByPId(pId);
    }

    public Enumeration insert(Enumeration target) {
        if (this.existsByNId(target.getNId())) throw new UnprocessableEntityException();

        return (mapper.insert(target) > 0) ? this.selectByNId(target.getNId()) : null;
    }

    public Enumeration update(Enumeration target) {
        if (!this.existsById(target.getId())) throw new UnprocessableEntityException();

        return (mapper.update(target) > 0) ? this.selectById(target.getId()) : null;
    }

    public Enumeration delete(Enumeration target) {
        if (!this.existsById(target.getId())) throw new UnprocessableEntityException();
        if (this.isUsedToPId(target.getId())) throw new AlreadyInUseException();

        return (mapper.delete(target) > 0) ? target : null;
    }

    private boolean existsById(String id) {
        return (mapper.selectById(id) == null) ? false : true;
    }

    private boolean existsByNId(String nId) {
        return (mapper.selectByNId(nId) == null) ? false : true;
    }

    private boolean isUsedToPId(String id) {
        return (mapper.selectByPId(id).isEmpty()) ? false : true;
    }
}
