package org;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class MpGenerator {


    @Test
    public void generate() {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("C:\\dev\\ideaProjects\\SpringBoot-MybatisPlus-skeleton\\src\\main\\java");
        gc.setAuthor("czy");
        gc.setOpen(false);
        //默认不覆盖，如果文件存在，将不会再生成，配置true就是覆盖
        gc.setFileOverride(true);


        //======================================
        gc.setServiceName("%sService"); //去掉Service接口的首字母I
        gc.setIdType(IdType.ASSIGN_ID); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true);//开启Swagger2模式
        //======================================
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mptest?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();//可以设置不生成xml
        pc.setModuleName("afc"); //模块名
        pc.setParent("org");
        pc.setController("controller");
        pc.setEntity("entities");
        pc.setService("service");
        pc.setMapper("mappers");
        pc.setXml("mappers.xml");
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
//        strategy.setSuperEntityClass("com.sjw.mybatisplus.generator.common.BaseEntity");// 自定义实体父类
        //lombok
        strategy.setEntityLombokModel(true);
//        strategy.setSuperControllerClass("com.sjw.mybatisplus.generator.common.BaseController");


        //表名字==>可以有个
        strategy.setInclude("test");
        strategy.setTablePrefix( "tb_");//生成实体时去掉表前缀
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true);//例如UserController   url中驼峰转连字符

        strategy.setEntityTableFieldAnnotationEnable(true);//应该是都加上@TableField

//        strategy.setSuperEntityColumns("id");// 自定义实体，公共字段
        mpg.setStrategy(strategy);


        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

//        configCustomizedCodeTemplate(mpg);
//        configInjection(mpg);

        mpg.execute();
    }
}
