package com.yebProject.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 此间凉汐
 * @date 2022/3/22 13:13
 */
public class CodeGenerator {
    /**
     * 读取控制台内容
     */
    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请输入" + tip + ":");
        System.out.println(stringBuilder.toString());
        if (scanner.hasNext()){
            String next = scanner.next();
            if(StringUtils.isNotEmpty(next)){
                return next;
            }
        }
        throw  new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/yeb-generator/src/main/java");
        gc.setAuthor("liangxi");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/yeb?useUnicode=true&characterEncoding=UTF-8&serviceTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Liangxi1125");
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.yebProject")
                .setEntity("pojo")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");
        mpg.setPackageInfo(pc);

        InjectionConfig cfg = new InjectionConfig(){
            @Override
            public void initMap() {
                //do something...
            }
        };

        String templatePath = "/templates/mapper.xml.ftl";

        ArrayList<FileOutConfig> foclist = new ArrayList<>();
        foclist.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/yeb-generator/src/main/resources/mapper/" +tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;

            }
        });
        cfg.setFileOutConfigList(foclist);
        mpg.setCfg(cfg);


        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        StrategyConfig strategy= new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.no_change);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，若有多个用英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);

        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
        System.out.println("it is ok...");
    }
}
//t_admin,t_admin_role,t_appraise,t_department,t_employee,t_employee_ec,t_employee_remove,t_employee_train
// ,t_joblevel,t_mail_log,t_menu,t_menu_role,
// t_nation,t_oplog,t_politics_status,t_position,t_role,t_salary,t_salary_adjust,t_sys_msg,t_sys_ms
