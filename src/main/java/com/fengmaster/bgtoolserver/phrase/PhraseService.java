package com.fengmaster.bgtoolserver.phrase;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.PathUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PhraseService {


    private String currentRunPath=System.getProperty("user.dir");

    public List<String> queryList(){
        return FileUtil.listFileNames(currentRunPath + File.separator + "phrase").stream().map(new Function<String, String>(){
            @Override
            public String apply(String s) {
                return FileUtil.mainName(s);
            }
        }).collect(Collectors.toList());

    }


    public List<String> getRandomPhrase(String phraseListName,int num){
        if (!queryList().contains(phraseListName)){
            return ListUtil.empty();
        }

        List<String> phrase = FileUtil.readLines(currentRunPath + File.separator + "phrase" +
                        File.separator + phraseListName + ".txt", StandardCharsets.UTF_8)
                .stream().filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return !s.startsWith("#");
                    }
                }).collect(Collectors.toList());

        return RandomUtil.randomEleList(phrase,num);
    }

}
