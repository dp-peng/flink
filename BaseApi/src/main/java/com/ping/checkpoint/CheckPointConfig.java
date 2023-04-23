package com.ping.checkpoint;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * ========================
 * module_name:[]
 * module_desc:
 *
 * @date: 2023/4/23
 * @since: 1.0
 * ========================
 */
public class CheckPointConfig {

    public static void setCheckpointParam(StreamExecutionEnvironment env){
        env.enableCheckpointing(30000);
    }
}
