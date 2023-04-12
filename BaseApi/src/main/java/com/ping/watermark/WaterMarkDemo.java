package com.ping.watermark;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;
import java.util.List;

/**
 * ========================
 * module_name:[]
 * module_desc:
 *
 * @author: dp
 * @date: 2023/4/6
 * @since: 1.0
 * ========================
 */
public class WaterMarkDemo {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(2);

        DataStreamSource<List<String>> streamSource = env.fromElements(Arrays.asList("a", "b", "c", "d", "e"));

        streamSource
                .keyBy(x->0)
                .map(new RichMapFunction<List<String>, String>() {
                    @Override
                    public void open(Configuration parameters) throws Exception {

                    }

                    @Override
                    public String map(List<String> strings) throws Exception {
                        return strings.toString();
                    }
                });
        streamSource.print();
    }
}
