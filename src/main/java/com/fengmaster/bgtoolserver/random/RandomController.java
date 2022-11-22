package com.fengmaster.bgtoolserver.random;

import com.fengmaster.bgtoolserver.phrase.PhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RandomController {

    @Autowired
    private RandomService randomService;


    @GetMapping(value = "/random/{start}/{end}/{num}")
    public List<String> getList(@PathVariable("start") int start,@PathVariable("end") int end, @PathVariable("num") int num,@RequestParam(value = "unique",defaultValue ="false") Boolean unique){
        return randomService.getList(start, end, num, unique);
    }

}
