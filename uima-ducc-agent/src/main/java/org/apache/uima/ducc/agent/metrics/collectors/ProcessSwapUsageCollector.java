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
package org.apache.uima.ducc.agent.metrics.collectors;

import java.util.concurrent.Callable;

import org.apache.uima.ducc.agent.launcher.CGroupsManager;
import org.apache.uima.ducc.agent.launcher.CGroupsManager.CgroupMemoryStat;
import org.apache.uima.ducc.common.agent.metrics.swap.DuccProcessSwapSpaceUsage;
import org.apache.uima.ducc.common.agent.metrics.swap.ProcessSwapSpaceUsage;
import org.apache.uima.ducc.common.utils.DuccLogger;

public class ProcessSwapUsageCollector implements Callable<ProcessSwapSpaceUsage> {
  private CGroupsManager cgm = null;

  private String containerId = null;

  public ProcessSwapUsageCollector(DuccLogger logger, CGroupsManager mgr, String jobId) {
    this.containerId = jobId;
    this.cgm = mgr;
  }

  public ProcessSwapSpaceUsage call() throws Exception {
    try {
      return new DuccProcessSwapSpaceUsage(collect());
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  private long collect() throws Exception {
    // use cgroups manager to collect rss usage
    return cgm.getUsageForMemoryStat(CgroupMemoryStat.SWAP, containerId);
  }
}
