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
package com.feilong.net.httpclient4;

import static com.feilong.core.bean.ConvertUtil.toMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @version 1.2.1 2015年6月6日 下午11:04:42
 * @since 1.2.1
 */
public class GetTestTemp{

    private static final Logger LOGGER = LoggerFactory.getLogger(GetTestTemp.class);

    @Test
    public void testGetResponseBodyAsString(){
        String uri = "http://127.0.0.1:8084";

        LOGGER.debug(HttpClientUtil.get(uri));
    }

    @Test
    public void testGetResponseBodyAsString1(){
        String uri = "http://127.0.0.1:8084?name=jinxin&age=18";
        LOGGER.debug(HttpClientUtil.get(uri));
    }

    @Test
    public void testGetResponseBodyAsString11(){
        String uri = "http://127.0.0.1:8084?name=jinxin&age=18";
        LOGGER.debug(HttpClientUtil.get(uri, toMap("country", "china")));
    }

    @Test
    public void testGetResponseBodyAsString121(){
        String uri = "http://127.0.0.1:8084";
        LOGGER.debug(HttpClientUtil.get(uri, toMap("country", "china")));
    }

}
