/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.thoughtworks.xstream.io.xml;

/**
 * WARNING: This is NOT the real XStream, it is a deliberately poisoned class for the purposes
 *          of verifying proper class separation in the CLI.  It is designed to d nothing
 *          but crash.
 */

public class DomDriver
{
    public DomDriver()
    {
        throw new IllegalStateException("I am not the DomDriver.");
    }

    // a non-failing constructor so we can verify the bogosity of these classes
    public DomDriver(String bogosity)
    {
        
    }
}
