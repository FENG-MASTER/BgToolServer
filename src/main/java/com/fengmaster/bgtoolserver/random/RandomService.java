package com.fengmaster.bgtoolserver.random;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RandomService {

    public List<String> getList( int start, int end, int num,  Boolean unique) {
        List<String> list = new ArrayList<>();
        if (start > end){
            return list;
        }

        if (unique){
            //要求唯一
            String[] integers=new String[end-start+1];

            for (int i = start; i <= end; i++) {
                integers[i-start]= String.valueOf(i );
            }

            integers=ArrayUtil.shuffle(integers);


            return Arrays.stream(ArrayUtil.sub(integers, 0, num)).collect(Collectors.toList());

        }else {
            for (int i = 0; i < num; i++) {
                list.add(String.valueOf(RandomUtil.randomInt(start, end)));
            }
        }

        return list;

    }
}
