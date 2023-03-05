package com.example.calc.log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lishengbing
 * @version 1.0
 * @date 2023-03-03 23:02:45
 * @description 计算操作的日志记录
 * @since JDK 1.8
 */
public class CalcLogger {

    private final int recordNum;
    private final List<Record> records;

    public CalcLogger(int recordNum) {
        this.recordNum = recordNum;
        this.records = new ArrayList<>(recordNum);
    }

    /**
     * 获取最新的一次计算记录
     */
    public Record getLastRecord() {
        if (records.isEmpty()) {
            return Record.fail("暂无运算操作记录，请输入运算表达式");
        }
        return records.get(0);
    }

    /**
     * 插入到第一个位置
     * 满足设定的限制容量
     *
     * @param record 运算日志记录
     */
    public void addRecord(Record record) {
        if (record.isError()) {
            return;
        }
        int size = records.size();
        if (size >= recordNum) {
            records.remove(size - 1);
        }
        records.add(0, record);
    }

    /**
     * 删除最近一次的操作记录
     */
    public void rmLastLog() {
        if (!records.isEmpty()) {
            records.remove(0);
        }
    }
}
