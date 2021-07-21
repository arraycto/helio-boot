package cc.uncarbon.module.sys.model.request;

import cc.uncarbon.module.sys.enums.GenderEnum;
import cc.uncarbon.module.sys.enums.SysUserStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


/**
 * 后台管理-新增/编辑后台用户
 * @author Uncarbon
 */
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminInsertOrUpdateSysUserDTO implements Serializable {

    @ApiModelProperty(value = "主键ID", hidden = true, notes = "仅更新时使用")
    private Long id;

    @ApiModelProperty(value = "所属租户ID", hidden = true, notes = "仅新增时使用")
    private Long tenantId;

    @ApiModelProperty(value = "账号", required = true)
    @NotBlank(message = "账号不能为空")
    private String username;

    @ApiModelProperty(value = "密码字符串(仅注册时有效)")
    private String passwordOfNewUser;

    @ApiModelProperty(value = "昵称", required = true)
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @ApiModelProperty(value = "状态", dataType = "Integer", required = true)
    @NotNull(message = "状态不能为空")
    private SysUserStatusEnum status;

    @ApiModelProperty(value = "性别", dataType = "Integer", required = true)
    @NotNull(message = "性别不能为空")
    private GenderEnum gender;

    @ApiModelProperty(value = "邮箱", required = true)
    @Pattern(message = "邮箱格式有误", regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "手机号", required = true)
    @Pattern(message = "手机号格式有误", regexp = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,89]))[0-9]{8}$")
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "所属部门ID")
    private Long deptId;

}
