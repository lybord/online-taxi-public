package com.ly.servicepassengeruser.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName passenger_user
 */
@TableName(value ="passenger_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerUser implements Serializable {
    /**
     * 乘客用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 乘客手机号
     */
    private String passengerPhone;

    /**
     * 乘客姓名
     */
    private String passengerName;

    /**
     * 乘客性别 0：女，1：男
     */
    private Integer passengerGender;

    /**
     * 乘客状态 0：有效，1：失效
     */
    private Integer state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}