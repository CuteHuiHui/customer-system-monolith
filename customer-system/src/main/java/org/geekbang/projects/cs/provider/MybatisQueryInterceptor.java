package org.geekbang.projects.cs.provider;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.mysql.cj.jdbc.DatabaseMetaData;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class MybatisQueryInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Object parameterObject = args[1];
        BoundSql boundSql = (BoundSql)args[5];
        // 解析SQL语句，获取操作的表名称
        Pattern pattern = Pattern.compile("FROM\\s+[`,\\w]+WHERE", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(boundSql.getSql());
        if (matcher.find()) {
            String tableName = matcher.group().replaceAll("FROM\\s+", "");
            System.out.println("操作的表名称为：" + tableName);
        }



        //对查询参数的处理，判断查询条件是否涉及加密字段，并进行加密处理
//        encryptDecryptService.encryptQueryParameter(parameterObject,boundSql);
        //获取结果集
        Object resultObject = invocation.proceed();
        if (!CollectionUtils.isEmpty((ArrayList) resultObject)) {
//            //完整性校验
//            integrityCheckService.checkSign(resultObject);
//            //解密
//            encryptDecryptService.decrypt(resultObject);
        }
        return resultObject;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}

