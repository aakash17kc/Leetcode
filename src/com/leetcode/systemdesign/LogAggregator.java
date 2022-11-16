package com.leetcode.systemdesign;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogAggregator {
    List<Log> logs = new ArrayList<>();


  public LogAggregator(int machines, int services) {

  }

  public void pushLog(int logId, int machineId, int serviceId, String message) {
      Log log = new Log(logId,machineId,serviceId,message);
      logs.add(log);
  }

  public List<Integer> getLogsFromMachine(int machineId) {
    return logs.stream().filter(log -> log.machineId == machineId).map(log -> log.logId).collect(Collectors.toList());
  }

  public List<Integer> getLogsOfService(int serviceId) {
    return logs.stream().filter(log -> log.serviceId == serviceId).map(log -> log.logId).collect(Collectors.toList());
  }

  public List<String> search(int serviceId, String searchString) {
    return logs.stream().filter(log -> log.serviceId == serviceId).filter(log -> log.message.contains(searchString)).map(log -> log.message).collect(Collectors.toList());
  }
}

class Log{
  int logId, machineId, serviceId;

  public Log(int logId, int machineId, int serviceId, String message) {
    this.logId = logId;
    this.machineId = machineId;
    this.serviceId = serviceId;
    this.message = message;
  }

  String message;


}
