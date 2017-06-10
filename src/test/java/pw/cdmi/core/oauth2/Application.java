/* 
 * 版权声明(Copyright Notice)：
 *     Copyright(C) 2017-2017 聚数科技成都有限公司。保留所有权利。
 *     Copyright(C) 2017-2017 www.cdmi.pw Inc. All rights reserved. 
 * 
 *     警告：本内容仅限于聚数科技成都有限公司内部传阅，禁止外泄以及用于其他的商业目
 */ 
package pw.cdmi.core.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/************************************************************
 * @Description:
 * <pre>
 * TODO(对类的简要描述说明 – 必须).<br/>
 * TODO(对类的作用含义说明 – 可选).<br/>
 * TODO(对类的使用方法说明 – 可选).<br/>
 * </pre>
 * @author    伍伟
 * @version   3.0.1
 * @Project   Alpha CDMI Service Platform, cdmi-core-oauth2 Component. 2017年6月4日
 ************************************************************/
@SpringBootApplication
@EnableAuthorizationServer
public class Application {

    /**
     * TODO(这里用一句话描述这个方法的作用 -必须).<br/>
     * TODO(这里描述这个方法的适用条件 -可选).<br/>
     * TODO(这里描述这个方法的执行流程 -可选).<br/>
     * TODO(这里描述这个方法的使用方法 -可选).<br/>
     * TODO(这里描述这个方法的注意事项 -可选).<br/>
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
