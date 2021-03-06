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
package com.feilong.net.httpclient4.builder.httpurirequest;

import static com.feilong.core.Validator.isNullOrEmpty;

import java.util.Map;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.net.UncheckedHttpException;
import com.feilong.net.entity.HttpRequest;

/**
 * The Class URIBuilderBuilder.
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/22038957/httpclient-getparams-deprecated-what-should-i-use-instead">HttpClient.getParams()
 *      deprecated. What should I use instead?
 *      </a>
 * @since 1.10.6
 */
class URIBuilderBuilder{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(URIBuilderBuilder.class);

    /** Don't let anyone instantiate this class. */
    private URIBuilderBuilder(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    //---------------------------------------------------------------

    /**
     * Builder.
     *
     * @param httpRequest
     *            the http request
     * @return the URI builder
     */
    static URIBuilder builder(HttpRequest httpRequest){
        try{
            URIBuilder uriBuilder = new URIBuilder(httpRequest.getUri());

            Map<String, String> paramMap = httpRequest.getParamMap();

            if (isNullOrEmpty(paramMap)){
                LOGGER.trace("input [paramMap] is null or empty ,skip!");
                return uriBuilder;
            }

            //-------------set params--------------------------------------------------
            for (Map.Entry<String, String> entry : paramMap.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();

                if (LOGGER.isTraceEnabled()){
                    LOGGER.trace("httpUriRequest.setHeader({}, {})", key, value);
                }
                uriBuilder.setParameter(key, value);
            }

            return uriBuilder;
        }catch (Exception e){
            throw new UncheckedHttpException(e);
        }
    }
}
