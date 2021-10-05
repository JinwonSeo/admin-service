package kr.sproutfx.platform.adminservice.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class MenuAndProgram {
    private String id;
    private String description;
    private String menuId;
    private String menuNId;
    private String menuName;
    private String menuIcon;
    private Integer menuSequence;
    private String menuDescription;
    private String menuPId;
    private String programId;
    private String programNId;
    private String programname;
    private String programPath;
    private Integer programSequence;
    private String programDescription;
}
