package kr.sproutfx.platform.adminservice.api.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Enumeration {
    private String id;
    private String nId;
    private String name;
    private Integer sequence;
    private boolean isActive;
    private boolean isDefault;
    private String description;
    private String pId;
    private boolean isLocked;
    private Timestamp createdOn;
    private String createUserId;
    private Timestamp lastUpdatedOn;
    private String lastUpdateUserId;
    private Timestamp deletedOn;
    private String deleteUserId;
}
