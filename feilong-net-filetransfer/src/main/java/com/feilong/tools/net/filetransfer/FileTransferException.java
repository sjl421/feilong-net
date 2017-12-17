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
package com.feilong.tools.net.filetransfer;

import com.feilong.tools.slf4j.Slf4jUtil;

/**
 * 文件传输遇到的异常.
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.7.1
 */
public final class FileTransferException extends RuntimeException{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1699987643831455524L;

    //---------------------------------------------------------------

    /**
     * The Constructor.
     *
     * @param messagePattern
     *            the message pattern
     * @param args
     *            the args
     */
    public FileTransferException(String messagePattern, Object...args){
        super(Slf4jUtil.format(messagePattern, args));
    }

    /**
     * The Constructor.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public FileTransferException(String message, Throwable cause){
        super(buildMessage(message, cause), cause);
    }

    //---------------------------------------------------------------

    /**
     * Builds the message.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     * @return the string
     * @since 1.10.4
     */
    private static String buildMessage(String message,Throwable cause){
        if (null == message){
            return cause.getMessage();
        }
        return message + ",error message:[" + cause.getMessage() + "]";
    }
}
