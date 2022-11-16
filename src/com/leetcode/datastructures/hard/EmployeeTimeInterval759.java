package com.leetcode.datastructures.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeTimeInterval759 {

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

    PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start );
    schedule.forEach(e -> pq.addAll(e));


    List<Interval> res = new ArrayList<>();

    Interval prev = pq.poll();

    while (!pq.isEmpty()) {
      Interval curr = pq.poll();

      if(prev.end < curr.start){
        Interval interval = new Interval(prev.end, curr.start);
        res.add(interval);
        prev = curr;
      }else{
        if(prev.end < curr.end){
          prev = curr;
        }
      }
    }

    return res;
  }


    public List<Interval> employeeFreeTime3(List<List<Interval>> schedule) {
      PriorityQueue<int[]> allEmployees = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);

      for (int i = 0; i < schedule.size(); i++) {
        allEmployees.add(new int[] { i, 0 });
      }

      List<Interval> employeesFreeTime = new ArrayList<>();

      int[] prev = allEmployees.peek();

      while (!allEmployees.isEmpty()) {
        int[] current = allEmployees.poll();

        Interval previousInterval = schedule.get(prev[0]).get(prev[1]);
        Interval currentInterval = schedule.get(current[0]).get(current[1]);

        if (currentInterval.start > previousInterval.end) {
          employeesFreeTime.add(new Interval(previousInterval.end, currentInterval.start));
        }

        if (currentInterval.end > previousInterval.end) {
          prev = current;
        }

        if (schedule.get(current[0]).size() > current[1] + 1) {
          allEmployees.add(new int[] { current[0], current[1] + 1 });
        }
      }

      return employeesFreeTime;
    }

  public static void main(String[] args) {
    List<List<Interval>> schedule = new ArrayList<>();
    List<Interval> int1 = new ArrayList<>();
    int1.add(new Interval(1,3));
    int1.add(new Interval(6,7));
    schedule.add(int1);
    List<Interval> int2 = new ArrayList<>();
    int2.add(new Interval(2,4));
    schedule.add(int2);
    List<Interval> int3 = new ArrayList<>();
    int3.add(new Interval(2,5));
    int3.add(new Interval(9,12));
    schedule.add(int3);
    new EmployeeTimeInterval759().employeeFreeTime3(schedule);
  }
}

class Interval {
  public int start;
  public int end;

  public Interval() {
  }

  public Interval(int _start, int _end) {
    start = _start;
    end = _end;
  }
}
