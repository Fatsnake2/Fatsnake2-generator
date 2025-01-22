### 本地代码生成器制作
#### 静态文件生成
> 1. 使用现成的工具库直接复制完成目录
> 2. 手动递归复制目录和文件
> 
> 方法一实现代码：
```angular2html
package com.Fatsnake.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
* 静态文件生成器
  */
  public class StaticGenerator {
  public static void main(String[] args) {
  String projectPath = System.getProperty("user.dir");
  File projectFile = new File(projectPath).getParentFile();
  //输入路径：ACM示例代码模板目录
  String inputPath = projectPath + File.separator + "Fatsnake-generator-demo-projects/acm-template";
  String outputPath = projectPath;
  copyFilesByHutool(inputPath,outputPath);
  }

  /**
  *拷贝文件(Hutool 实现。会将输入路径的目录拷贝到输出路径的目录中
    * @param inputPath 输入路径
    * @param outputPath 输出路径
      */
      public static void copyFilesByHutool(String inputPath, String outputPath) {
      FileUtil.copy(inputPath, outputPath, true);
      }
}
```
#### freemarker实战
> 使用freemarker来进行制作
> 1. 在pom.xml文件里面引入依赖
```angular2html
<!-- https://freemarker.apache.org/index.html -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.32</version>
</dependency>

```
> 2. 创建配置对象
```
//全局指定freemarker的制定规则
// new 出 Configuration 对象，参数为 FreeMarker 版本号
Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

// 指定模板文件所在的路径
configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

// 设置模板文件使用的字符集
configuration.setDefaultEncoding("utf-8");

```
> 3. 准备模板并且加载
```angular2html
// 创建模板对象，加载指定模板
Template template = configuration.getTemplate("myweb.html.ftl");

```
> 4. 创建数据模型
```angular2html
Map<String, Object> dataModel = new HashMap<>();
dataModel.put("currentYear", 2023);
List<Map<String, Object>> menuItems = new ArrayList<>();
Map<String, Object> menuItem1 = new HashMap<>();
menuItem1.put("url", "https://codefather.cn");
menuItem1.put("label", "编程导航");
Map<String, Object> menuItem2 = new HashMap<>();
menuItem2.put("url", "https://laoyujianli.com");
menuItem2.put("label", "老鱼简历");
menuItems.add(menuItem1);
menuItems.add(menuItem2);
dataModel.put("menuItems", menuItems);

```
> 5. 指定生成文件
```angular2html
Writer out = new FileWriter("myweb.html");

```
> 6. 生成文件
```angular2html
template.process(dataModel, out);

// 生成文件后别忘了关闭哦
out.close();

```
#### 动态文件生成
> 1. 定义数据模型
```angular2html
/**
 * 动态模版配置
 */
@Data
public class MainTemplateConfig {

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
}

```
> 2. 编写动态模板
```angular2html
package com.yupi.acm;

import java.util.Scanner;

/**
 * ACM 输入模板（多数之和）
 * @author ${author}
 */
public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

<#if loop>
        while (scanner.hasNext()) {
</#if>
            // 读取输入元素个数
            int n = scanner.nextInt();

            // 读取数组
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // 处理问题逻辑，根据需要进行输出
            // 示例：计算数组元素的和
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }

            System.out.println("${outputText}" + sum);
<#if loop>
        }
</#if>
        scanner.close();
    }
}


```
> 3. 组合生成
```angular2html
/**
 * 动态文件生成
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("MainTemplate.java.ftl");

        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        // 不使用循环
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");

        // 生成
        Writer out = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig, out);

        // 生成文件后别忘了关闭哦
        out.close();
    }

}

```
> 4. 完善优化
```angular2html
//给数据模型增加默认值
/**
* 动态模版配置
*/
@Data
public class MainTemplateConfig {

/**
* 是否生成循环
*/
private boolean loop;

/**
* 作者注释
*/
private String author = "yupi";

/**
* 输出信息
*/
private String outputText = "sum = ";
}

```
> 5. 动静结合，生成完整代码
```angular2html
package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     * 
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}


```

### java命令行开发


