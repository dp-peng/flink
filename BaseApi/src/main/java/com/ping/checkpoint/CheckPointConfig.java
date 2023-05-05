package com.ping.checkpoint;

import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 *
 */
public class CheckPointConfig {

    public static void setCheckpointParam(StreamExecutionEnvironment env){
        env.enableCheckpointing(30000);

        CheckpointConfig checkpointConfig = env.getCheckpointConfig();

        checkpointConfig.setCheckpointTimeout(1000);

        checkpointConfig.setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);

        checkpointConfig.setCheckpointInterval(20000);


    }
}
