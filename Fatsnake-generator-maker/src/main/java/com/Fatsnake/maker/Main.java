package com.Fatsnake.maker;

import com.Fatsnake.maker.generator.main.GenerateTemplate;
import com.Fatsnake.maker.generator.main.MainGenerator;
import com.Fatsnake.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;
public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        GenerateTemplate generateTemplate = new MainGenerator();
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}
