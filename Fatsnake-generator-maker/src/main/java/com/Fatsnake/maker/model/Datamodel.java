package com.Fatsnake.maker.model;

import lombok.Data;

/**
 * 动态模版配置
 */
@Data
public class Datamodel {

    /**
     * 是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author;

    /**
     * 输出信息
     */
    private String outputText;
    /**
     * 核心模板
     */
    public MainTemplate mainTemplate;/**

    /**
     * 用于生成核心模板文件
     */
    @Data
    public static class MainTemplate {
        /**
         * 作者注释
         */
        public String author = "Fatsnake";

        /**
         * 输出信息
         */
        public String outputText = "sum = ";
    }

}

