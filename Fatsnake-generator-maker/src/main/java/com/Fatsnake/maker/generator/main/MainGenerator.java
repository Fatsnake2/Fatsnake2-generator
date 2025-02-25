package com.Fatsnake.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.Fatsnake.maker.generator.JarGenerator;
import com.Fatsnake.maker.generator.ScriptGenerator;
import com.Fatsnake.maker.generator.file.DynamicFileGenerator;
import com.Fatsnake.maker.meta.Meta;
import com.Fatsnake.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

//public class MainGenerator {
//
//    public static void main(String[] args) throws TemplateException, IOException, TemplateException, IOException, InterruptedException {
//        Meta meta = MetaManager.getMetaObject();
//        System.out.println(meta);
//
//        // 输出根路径
//        String projectPath = System.getProperty("user.dir");
//        String outputPath = projectPath + File.separator + "generated" + File.separator + meta.getName();
//        if (!FileUtil.exist(outputPath)) {
//            FileUtil.mkdir(outputPath);
//        }
//
//        // 复制原始文件
//        String sourceRootPath = meta.getFileConfig().getSourceRootPath();
//        String sourceCopyDestPath = outputPath + File.separator + ".source";
//        FileUtil.copy(sourceRootPath, sourceCopyDestPath, false);
//
//        // 读取 resources 目录
//        ClassPathResource classPathResource = new ClassPathResource("");
//        String inputResourcePath = classPathResource.getAbsolutePath();
//
//        // Java 包基础路径
//        String outputBasePackage = meta.getBasePackage();
//        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(outputBasePackage, "."));
//        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/" + outputBasePackagePath;
//
//        String inputFilePath;
//        String outputFilePath;
//
//        // model.DataModel
//        inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/model/DataModel.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // cli.command.ConfigCommand
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ConfigCommand.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // cli.command.GenerateCommand
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/cli/command/GenerateCommand.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // cli.command.ListCommand
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ListCommand.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // cli.CommandExecutor
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/cli/CommandExecutor.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // Main
//        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/Main.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // generator.DynamicGenerator
//        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/DynamicGenerator.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/generator/DynamicGenerator.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // generator.MainGenerator
//        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/MainGenerator.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/generator/MainGenerator.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // generator.StaticGenerator
//        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/StaticGenerator.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/generator/StaticGenerator.java";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // pom.xml
//        inputFilePath = inputResourcePath + File.separator + "templates/pom.xml.ftl";
//        outputFilePath = outputPath + File.separator + "pom.xml";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // README.md
//        inputFilePath = inputResourcePath + File.separator + "templates/README.md.ftl";
//        outputFilePath = outputPath + File.separator + "README.md";
//        DynamicFileGenerator.doGenerate(inputFilePath , outputFilePath, meta);
//
//        // 构建 jar 包
//        JarGenerator.doGenerate(outputPath);
//
//        // 封装脚本
//        String shellOutputFilePath = outputPath + File.separator + "generator";
//        String jarName = String.format("%s-%s-jar-with-dependencies.jar", meta.getName(), meta.getVersion());
//        String jarPath = "target/" + jarName;
//        ScriptGenerator.doGenerate(shellOutputFilePath, jarPath);
//
//        // 生成精简版的程序（产物包）
//        String distOutputPath = outputPath + "-dist";
//        // - 拷贝 jar 包
//        String targetAbsolutePath = distOutputPath + File.separator + "target";
//        FileUtil.mkdir(targetAbsolutePath);
//        String jarAbsolutePath = outputPath + File.separator + jarPath;
//        FileUtil.copy(jarAbsolutePath, targetAbsolutePath, true);
//        // - 拷贝脚本文件
//        FileUtil.copy(shellOutputFilePath, distOutputPath, true);
//        FileUtil.copy(shellOutputFilePath + ".bat", distOutputPath, true);
//        // - 拷贝源模板文件
//        FileUtil.copy(sourceCopyDestPath, distOutputPath, true);
//    }
//}

/**
 * 生成代码生成器
 */
public class MainGenerator extends GenerateTemplate {

    @Override
    protected String buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不要给我输出 dist 啦！");
        return "";
    }
//    public static void main(String[] args) throws IOException, TemplateException , InterruptedException {
//        MainGenerator mainGenerator = new MainGenerator();
//        mainGenerator.doGenerate();
//    }
}


