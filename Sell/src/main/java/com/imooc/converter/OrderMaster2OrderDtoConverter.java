package com.imooc.converter;

import com.imooc.dto.OrderDto;
import com.imooc.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 廖师兄
 * 2017-06-11 22:02
 */
public class OrderMaster2OrderDtoConverter {

    public static OrderDto convert(OrderMaster orderMaster) {

        OrderDto orderDTO = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
