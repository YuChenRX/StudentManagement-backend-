package oil.moe.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 
* @TableName oauth_client_details
*/
@Entity
@Data
@Table(name = "oauth_client_details")
@AllArgsConstructor
@NoArgsConstructor
public class OauthClientDto{

    /**
    * 
    */
    @Id
    @ApiModelProperty("clientId")
    @Column
    private String clientId;
    /**
    * 
    */
    @ApiModelProperty("resourceIds")
    @Column
    private String resourceIds;
    /**
    * 
    */
    @ApiModelProperty("clientSecret")
    @Column
    private String clientSecret;
    /**
    * 
    */
    @ApiModelProperty("scope")
    @Column
    private String scope;
    /**
    * 
    */
    @ApiModelProperty("authorizedGrantTypes")
    @Column
    private String authorizedGrantTypes;
    /**
    * 
    */
    @ApiModelProperty("webServerRedirectUri")
    @Column
    private String webServerRedirectUri;
    /**
    * 
    */
    @ApiModelProperty("authorities")
    @Column
    private String authorities;
    /**
    * 
    */
    @ApiModelProperty("accessTokenValidity")
    @Column
    private Integer accessTokenValidity;
    /**
    * 
    */
    @ApiModelProperty("refreshTokenValidity")
    @Column
    private Integer refreshTokenValidity;
    /**
    * 
    */
    @ApiModelProperty("additionalInformation")
    @Column
    private String additionalInformation;
    /**
    * 
    */
    @ApiModelProperty("autoapprove")
    @Column
    private String autoapprove;
}
