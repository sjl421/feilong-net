/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.net.httpclient4.builder;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * HttpClient 构造器.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.10.6
 */
class HttpClientBuilder{

    /** Don't let anyone instantiate this class. */
    private HttpClientBuilder(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    //---------------------------------------------------------------

    /**
     * 创造 {@link HttpClient}.
     *
     * @return the closeable http client
     */
    static HttpClient build(){
        //TODO 处理 https
        CloseableHttpClient createDefault = HttpClients.createDefault();

        //        org.apache.http.impl.client.HttpClientBuilder customHttpClientBuilder = HttpClients.custom();
        //        customHttpClientBuilder.setSSLContext(sslContext);
        //        customHttpClientBuilder.setConnectionManager(connManager);
        //        CloseableHttpClient httpClient = customHttpClientBuilder.build();
        return createDefault;
    }
}
